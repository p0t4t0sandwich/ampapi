package modules

import (
	"github.com/p0t4t0sandwich/ampapi-go"
	"github.com/p0t4t0sandwich/ampapi-go/apimodules"
)

// Struct GenericModule
type GenericModule struct {
	CommonAPI
	GenericModule  *apimodules.GenericModule
	RCONPlugin     *apimodules.RCONPlugin
	Steamcmdplugin *apimodules.Steamcmdplugin
}

// Function NewGenericModule
// Creates a new GenericModule object
func NewGenericModule(baseUri string, optional ...string) (*GenericModule, error) {
	var genericModule = new(GenericModule)

	capi, _ := NewCommonAPI(baseUri, optional...)
	genericModule.CommonAPI = *capi

	genericModule.GenericModule = apimodules.NewGenericModule(&genericModule.AMPAPI)
	genericModule.RCONPlugin = apimodules.NewRCONPlugin(&genericModule.AMPAPI)
	genericModule.Steamcmdplugin = apimodules.NewSteamcmdplugin(&genericModule.AMPAPI)

	var err error = nil
	if genericModule.AMPAPI.Username != "" && (genericModule.AMPAPI.Password != "" || genericModule.AMPAPI.RememberMeToken != "") {
		_, err = genericModule.Login()
	}

	return genericModule, err
}

// Simplified login function
func (genericModule *GenericModule) Login() (ampapi.LoginResult, error) {
	loginResult, err := genericModule.AMPAPI.Login()

	if loginResult.Success {
		genericModule.AMPAPI.SessionId = loginResult.SessionId
		genericModule.AMPAPI.RememberMeToken = loginResult.RememberMeToken

		// Update the session ID and remember me token of submodules
		genericModule.GenericModule.SessionId = loginResult.SessionId
		genericModule.GenericModule.RememberMeToken = loginResult.RememberMeToken
		genericModule.RCONPlugin.SessionId = loginResult.SessionId
		genericModule.RCONPlugin.RememberMeToken = loginResult.RememberMeToken
		genericModule.Steamcmdplugin.SessionId = loginResult.SessionId
		genericModule.Steamcmdplugin.RememberMeToken = loginResult.RememberMeToken
	}

	return loginResult, err
}
