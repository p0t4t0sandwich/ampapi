package apimodules

// A Go library for the AMP API
// Author: p0t4t0sandich

import (
	"encoding/json"

	"github.com/p0t4t0sandwich/ampapi-go"
)

// struct GenericModule
type GenericModule struct {
    *ampapi.AMPAPI
}

// Function NewGenericModule
// Creates a new GenericModule object
func NewGenericModule(api *ampapi.AMPAPI) *GenericModule {
	return &GenericModule{api}
}

/* ImportConfig - 
 * Name Description Optional
 * param filename string  False
 * return map[string]string
 */
func (a *GenericModule) ImportConfig(filename string) (map[string]string, error) {
    var args = make(map[string]any)
    args["filename"] = filename
    var res map[string]string
    bytes, err := a.ApiCall("GenericModule/ImportConfig", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

