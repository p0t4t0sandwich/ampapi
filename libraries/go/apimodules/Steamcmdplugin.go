package apimodules

// A Go library for the AMP API
// Author: p0t4t0sandich

import (
	"encoding/json"

	"github.com/p0t4t0sandwich/ampapi-go"
)

// struct Steamcmdplugin
type Steamcmdplugin struct {
    *ampapi.AMPAPI
}

// Function NewSteamcmdplugin
// Creates a new Steamcmdplugin object
func NewSteamcmdplugin(api *ampapi.AMPAPI) *Steamcmdplugin {
	return &Steamcmdplugin{api}
}

/* CancelSteamGuard - 
 * Name Description Optional
 * return any
 */
func (a *Steamcmdplugin) CancelSteamGuard() (any, error) {
    var args = make(map[string]any)
    var res any
    bytes, err := a.ApiCall("Steamcmdplugin/CancelSteamGuard", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* SteamGuardCode - 
 * Name Description Optional
 * param code string  False
 * return any
 */
func (a *Steamcmdplugin) SteamGuardCode(code string) (any, error) {
    var args = make(map[string]any)
    args["code"] = code
    var res any
    bytes, err := a.ApiCall("Steamcmdplugin/SteamGuardCode", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* SteamUsernamePassword - 
 * Name Description Optional
 * param username string  False
 * param password string  False
 * return any
 */
func (a *Steamcmdplugin) SteamUsernamePassword(username string, password string) (any, error) {
    var args = make(map[string]any)
    args["username"] = username
    args["password"] = password
    var res any
    bytes, err := a.ApiCall("Steamcmdplugin/SteamUsernamePassword", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

