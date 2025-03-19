package modules

import (
	"github.com/p0t4t0sandwich/ampapi-go"
	"github.com/p0t4t0sandwich/ampapi-go/apimodules"
)

// Struct CommonAPI
type CommonAPI struct {
	ampapi.AMPAPI
	Core                  *apimodules.Core
	EmailSenderPlugin     *apimodules.EmailSenderPlugin
	FileManagerPlugin     *apimodules.FileManagerPlugin
	LocalFileBackupPlugin *apimodules.LocalFileBackupPlugin
}

// Function NewCommonAPI
// Creates a new CommonAPI object
func NewCommonAPI(baseUri string, optional ...string) (*CommonAPI, error) {
	var commonAPI = new(CommonAPI)

	commonAPI.AMPAPI = *ampapi.NewAMPAPI(baseUri, optional...)

	commonAPI.Core = apimodules.NewCore(&commonAPI.AMPAPI)
	commonAPI.EmailSenderPlugin = apimodules.NewEmailSenderPlugin(&commonAPI.AMPAPI)
	commonAPI.FileManagerPlugin = apimodules.NewFileManagerPlugin(&commonAPI.AMPAPI)
	commonAPI.LocalFileBackupPlugin = apimodules.NewLocalFileBackupPlugin(&commonAPI.AMPAPI)

	var err error = nil
	if commonAPI.AMPAPI.Username != "" && (commonAPI.AMPAPI.Password != "" || commonAPI.AMPAPI.RememberMeToken != "") {
		_, err = commonAPI.Login()
	}

	return commonAPI, err
}

// Simplified login function
func (commonAPI *CommonAPI) Login() (ampapi.LoginResult, error) {
	loginResult, err := commonAPI.AMPAPI.Login()

	if loginResult.Success {
		commonAPI.AMPAPI.SessionId = loginResult.SessionId
		commonAPI.AMPAPI.RememberMeToken = loginResult.RememberMeToken

		// Update the session ID and remember me token of submodules
		commonAPI.Core.SessionId = loginResult.SessionId
		commonAPI.Core.RememberMeToken = loginResult.RememberMeToken
		commonAPI.EmailSenderPlugin.SessionId = loginResult.SessionId
		commonAPI.EmailSenderPlugin.RememberMeToken = loginResult.RememberMeToken
		commonAPI.FileManagerPlugin.SessionId = loginResult.SessionId
		commonAPI.FileManagerPlugin.RememberMeToken = loginResult.RememberMeToken
		commonAPI.LocalFileBackupPlugin.SessionId = loginResult.SessionId
		commonAPI.LocalFileBackupPlugin.RememberMeToken = loginResult.RememberMeToken
	}

	return loginResult, err
}
