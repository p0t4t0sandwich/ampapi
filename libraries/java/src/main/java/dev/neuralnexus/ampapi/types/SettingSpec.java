package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * A setting specification object
 * @param Actions The actions
 * @param AlwaysAllowRead Whether the setting is always allowed to be read
 * @param Attributes The attributes
 * @param Category The category
 * @param CurrentValue The current value
 * @param Description The description
 * @param EnumValuesAreDeferred Whether the enum values are deferred
 * @param InputType The input type
 * @param IsProvisionSpec Whether the setting is a provision spec
 * @param Keywords The keywords
 * @param MaxLength The max length
 * @param Meta The meta
 * @param Name The name
 * @param Node The node
 * @param Order The order
 * @param Placeholder The placeholder
 * @param ReadOnly Whether the setting is read-only
 * @param ReadOnlyProvision Whether the provision is read-only
 * @param Required Whether the setting is required
 * @param RequiresRestart Whether the setting requires a restart
 * @param Subcategory The subcategory
 * @param Suffix The suffix
 * @param Tag The tag
 * @param ValType The value type
 * @param EnumValues The enum values
 * @param MaxValue The max value
 * @param MinValue The min value
 * @param SelectionSource The selection source
 */
public record SettingSpec(List<InlineActionAttribute> Actions, Boolean AlwaysAllowRead, Object Attributes, String Category, Object CurrentValue, String Description, Boolean EnumValuesAreDeferred, String InputType, Boolean IsProvisionSpec, String Keywords, Integer MaxLength, String Meta, String Name, String Node, Integer Order, String Placeholder, Boolean ReadOnly, Boolean ReadOnlyProvision, Boolean Required, Boolean RequiresRestart, String Subcategory, String Suffix, String Tag, String ValType, Optional<Map<String, String>> EnumValues, Optional<Float> MaxValue, Optional<Float> MinValue, Optional<StringSelectionSourceAttribute> SelectionSource) {}
