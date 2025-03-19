package modules

import (
	"github.com/p0t4t0sandwich/ampapi-go"
	"github.com/p0t4t0sandwich/ampapi-go/apimodules"
)

// Struct Minecraft
type Minecraft struct {
	CommonAPI
	MinecraftModule *apimodules.MinecraftModule
}

// Function NewMinecraft
// Creates a new Minecraft object
func NewMinecraft(baseUri string, optional ...string) (*Minecraft, error) {
	var minecraft = new(Minecraft)

	capi, _ := NewCommonAPI(baseUri, optional...)
	minecraft.CommonAPI = *capi

	minecraft.MinecraftModule = apimodules.NewMinecraftModule(&minecraft.AMPAPI)

	var err error = nil
	if minecraft.AMPAPI.Username != "" && (minecraft.AMPAPI.Password != "" || minecraft.AMPAPI.RememberMeToken != "") {
		_, err = minecraft.Login()
	}

	return minecraft, err
}

// Simplified login function
func (minecraft *Minecraft) Login() (ampapi.LoginResult, error) {
	loginResult, err := minecraft.AMPAPI.Login()

	if loginResult.Success {
		minecraft.AMPAPI.SessionId = loginResult.SessionId
		minecraft.AMPAPI.RememberMeToken = loginResult.RememberMeToken

		// Update the session ID and remember me token of submodules
		minecraft.MinecraftModule.SessionId = loginResult.SessionId
		minecraft.MinecraftModule.RememberMeToken = loginResult.RememberMeToken
	}

	return loginResult, err
}
