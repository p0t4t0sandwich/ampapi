package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * A deployment template object
 * @param CloneRoleIntoUser Whether to clone the role into the user
 * @param Description The description
 * @param Id The ID
 * @param MatchDatastoreTags Whether to match datastore tags
 * @param Module The module
 * @param Name The name
 * @param SettingMappings The setting mappings
 * @param StartOnBoot Whether to start on boot
 * @param Tags The tags
 * @param TemplateBaseApp The template base app
 * @param ZipOverlayPath The zip overlay path
 * @param TemplateInstance The template instance
 * @param TemplateRole The template role
 */
public record DeploymentTemplate(Boolean CloneRoleIntoUser, String Description, Integer Id, Boolean MatchDatastoreTags, String Module, String Name, Map<String, String> SettingMappings, Boolean StartOnBoot, List<String> Tags, String TemplateBaseApp, String ZipOverlayPath, Optional<UUID> TemplateInstance, Optional<UUID> TemplateRole) {}
