package ampapi

import (
	"bytes"
	"errors"
	"fmt"
	"io"
	"net/http"

	"github.com/goccy/go-json"
	"github.com/google/uuid"
)

// APICall is a function that takes an endpoint and returns the response
func APICall(endpoint string, requestMethod string, args map[string]any, ret *any) error {
	body := new(bytes.Buffer)
	json.NewEncoder(body).Encode(args)

	client := &http.Client{}
	req, err := http.NewRequest(requestMethod, endpoint, body)
	if err != nil {
		return err
	}
	defer req.Body.Close()

	req.Header.Add("Accept", "application/json")
	req.Header.Add("Content-Type", "application/json")
	req.Header.Add("User-Agent", "ampapi-go/"+Version)
	resp, err := client.Do(req)

	if err != nil {
		return err
	}

	data, err := io.ReadAll(resp.Body)
	if err != nil {
		return err
	}

	// Check for API-related errors
	var errorResult AMPError
	json.Unmarshal(data, &errorResult)

	if errorResult.Title != "" && errorResult.Message != "" && errorResult.StackTrace != "" {
		return fmt.Errorf("%s: %s\n%s", errorResult.Title, errorResult.Message, errorResult.StackTrace)
	}

	// Unmarshal into the return struct
	json.Unmarshal(data, ret)
	return nil
}

// AuthProvider a general interface for logging into the remote AMP instance
type AuthProvider interface {
	InstanceName() string
	InstanceID() uuid.UUID
	APICall(endpoint string, args map[string]any, ret *any) error
	Login(rememberMe bool) error
	UpdateModuleInfo() error
}

// AuthStore a struct to aid in keeping track of login tokens
type AuthStore struct {
	authProviders map[uuid.UUID]AuthProvider // A map of AuthProviders keyed by the InstanceID
}

func (s *AuthStore) Get(instanceId uuid.UUID) (AuthProvider, error) {
	if ap, ok := s.authProviders[instanceId]; ok {
		return ap, nil
	}
	return nil, errors.New("instance with ID" + instanceId.String() + " is not stored.")
}

func (s *AuthStore) Add(ap AuthProvider) {
	s.AddById(ap, ap.InstanceID())
}

func (s *AuthStore) AddById(ap AuthProvider, instanceId uuid.UUID) {
	s.authProviders[instanceId] = ap
}

func (s *AuthStore) Remove(ap AuthProvider) {
	s.RemoveById(ap.InstanceID())
}

func (s *AuthStore) RemoveById(instanceId uuid.UUID) {
	delete(s.authProviders, instanceId)
}

func NewAuthStore() *AuthStore {
	authProviders := make(map[uuid.UUID]AuthProvider)
	return &AuthStore{authProviders}
}
