package apimodules

// A Go library for the AMP API
// Author: p0t4t0sandich

import (
	"encoding/json"

	"github.com/p0t4t0sandwich/ampapi-go"
)

// struct EmailSenderPlugin
type EmailSenderPlugin struct {
    *ampapi.AMPAPI
}

// Function NewEmailSenderPlugin
// Creates a new EmailSenderPlugin object
func NewEmailSenderPlugin(api *ampapi.AMPAPI) *EmailSenderPlugin {
	return &EmailSenderPlugin{api}
}

/* TestSMTPSettings - 
 * Name Description Optional
 * return ampapi.ActionResult[any]
 */
func (a *EmailSenderPlugin) TestSMTPSettings() (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("EmailSenderPlugin/TestSMTPSettings", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

