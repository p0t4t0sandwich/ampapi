package apimodules

// A Go library for the AMP API
// Author: p0t4t0sandich

import (
	"encoding/json"

	"github.com/p0t4t0sandwich/ampapi-go"
)

// struct LocalFileBackupPlugin
type LocalFileBackupPlugin struct {
    *ampapi.AMPAPI
}

// Function NewLocalFileBackupPlugin
// Creates a new LocalFileBackupPlugin object
func NewLocalFileBackupPlugin(api *ampapi.AMPAPI) *LocalFileBackupPlugin {
	return &LocalFileBackupPlugin{api}
}

/* DeleteFromS3 - 
 * Name Description Optional
 * param BackupId ampapi.UUID  False
 * return ampapi.ActionResult[any]
 */
func (a *LocalFileBackupPlugin) DeleteFromS3(BackupId ampapi.UUID) (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    args["BackupId"] = BackupId
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("LocalFileBackupPlugin/DeleteFromS3", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* DeleteLocalBackup - 
 * Name Description Optional
 * param BackupId ampapi.UUID  False
 * return any
 */
func (a *LocalFileBackupPlugin) DeleteLocalBackup(BackupId ampapi.UUID) (any, error) {
    var args = make(map[string]any)
    args["BackupId"] = BackupId
    var res any
    bytes, err := a.ApiCall("LocalFileBackupPlugin/DeleteLocalBackup", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* DownloadFromS3 - 
 * Name Description Optional
 * param BackupId ampapi.UUID  False
 * return ampapi.RunningTask
 */
func (a *LocalFileBackupPlugin) DownloadFromS3(BackupId ampapi.UUID) (ampapi.RunningTask, error) {
    var args = make(map[string]any)
    args["BackupId"] = BackupId
    var res ampapi.RunningTask
    bytes, err := a.ApiCall("LocalFileBackupPlugin/DownloadFromS3", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* GetBackups - 
 * Name Description Optional
 * return []any
 */
func (a *LocalFileBackupPlugin) GetBackups() ([]any, error) {
    var args = make(map[string]any)
    var res []any
    bytes, err := a.ApiCall("LocalFileBackupPlugin/GetBackups", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* RestoreBackup - 
 * Name Description Optional
 * param BackupId ampapi.UUID  False
 * param DeleteExistingData bool  True
 * return ampapi.ActionResult[any]
 */
func (a *LocalFileBackupPlugin) RestoreBackup(BackupId ampapi.UUID, DeleteExistingData bool) (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    args["BackupId"] = BackupId
    args["DeleteExistingData"] = DeleteExistingData
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("LocalFileBackupPlugin/RestoreBackup", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* SetBackupSticky - 
 * Name Description Optional
 * param BackupId ampapi.UUID  False
 * param Sticky bool  False
 * return any
 */
func (a *LocalFileBackupPlugin) SetBackupSticky(BackupId ampapi.UUID, Sticky bool) (any, error) {
    var args = make(map[string]any)
    args["BackupId"] = BackupId
    args["Sticky"] = Sticky
    var res any
    bytes, err := a.ApiCall("LocalFileBackupPlugin/SetBackupSticky", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* TakeBackup - 
 * Name Description Optional
 * param Title string  False
 * param Description string  False
 * param Sticky bool  False
 * return ampapi.ActionResult[any]
 */
func (a *LocalFileBackupPlugin) TakeBackup(Title string, Description string, Sticky bool) (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    args["Title"] = Title
    args["Description"] = Description
    args["Sticky"] = Sticky
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("LocalFileBackupPlugin/TakeBackup", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* UploadToS3 - 
 * Name Description Optional
 * param BackupId ampapi.UUID  False
 * return ampapi.RunningTask
 */
func (a *LocalFileBackupPlugin) UploadToS3(BackupId ampapi.UUID) (ampapi.RunningTask, error) {
    var args = make(map[string]any)
    args["BackupId"] = BackupId
    var res ampapi.RunningTask
    bytes, err := a.ApiCall("LocalFileBackupPlugin/UploadToS3", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

