#!/bin/python3
"""Java CodeGen implementation"""

from json import loads
from typing import Any

import re
import sys
sys.path.append("../../../")
from validate_types import TypeDef, TypeField

# C# to Java
cs_to_java = {
    "Boolean": "Boolean",
    "DateTime": "String",
    "Dictionary": "Map",
    "Double": "Double",
    "Float": "Float",
    "Guid": "UUID",
    "Int32": "Integer",
    "Int64": "Integer",
    "IPAddress": "InetAddress",
    "JSONRawResponse": "Map<String, Object>",
    "JObject": "Map<String, Object>",
    "List": "List",
    "Object": "Object",
    "String": "String",
    "TimeSpan": "String",
    "Uri": "URI",
    "Void": "Void",

    "Generic": "T",
}

class CodeGen:
    """CodeGen Class"""
    APISpec: dict[str, dict[str, Any]] = {}
    TypeSpec: dict[str, TypeDef] = {}
    ModuleInheritance: dict[str, list[str]] = {}

    def _load_api_spec(self) -> None:
            with open("../../../TypedAPISpec.json", encoding="UTF-8") as file:
                json_str: str = file.read()
                self.APISpec = loads(json_str)

    def _load_type_spec(self) -> None:
        with open("../../../TypeSpec.json", encoding="UTF-8") as file:
            json_str: str = file.read()
            for type_name, type_def in loads(json_str).items():
                self.TypeSpec[type_name] = TypeDef(
                    Description=type_def["Description"],
                    Fields=[TypeField(**field) for field in type_def["Fields"]],
                    SpecialNote=type_def.get("SpecialNote"),
                    SpecialType=type_def.get("SpecialType"),
                    SerializesAs=type_def.get("SerializesAs")
                )

    def _load_module_inheritance(self) -> None:
            with open("../../../ModuleInheritance.json", encoding="UTF-8") as file:
                json_str: str = file.read()
                self.ModuleInheritance = loads(json_str)

    def __init__(self) -> None:
            self._load_api_spec()
            self._load_type_spec()
            self._load_module_inheritance()

    def _convert_type(self, type_name: str, optional: bool = False) -> str:
            converted_type = ""
            if type_name.startswith("List<"):
                inner = type_name.replace("List<", "").replace(">", "")
                t = self._convert_type(inner)
                converted_type = f"List<{t}>"
            elif type_name.startswith("Dictionary<"):
                stripped = type_name[11:-1]
                split = stripped.split(", ", 1)
                left = self._convert_type(split[0])
                right = self._convert_type(split[1])
                converted_type = f"Map<{left}, {right}>"
            elif "Nullable<" in type_name:
                t = type_name.replace("Nullable<", "").replace(">", "")
                if t in cs_to_java:
                    t = cs_to_java[t]
                converted_type = f"{t}"
            elif "ActionResult<" in type_name:
                t = type_name.replace("ActionResult<", "").replace(">", "")
                if t in cs_to_java:
                    t = cs_to_java[t]
                converted_type = f"ActionResult<{t}>"
            else:
                if type_name in cs_to_java:
                    converted_type = cs_to_java[type_name]
                else:
                    converted_type = type_name

            if optional:
                converted_type = f"Optional<{converted_type}>"

            return converted_type

    def generate_types(self) -> None:
        """Generates API Types"""
        text = ""
        type_base = ""
        with open("./templates/type_base.txt", encoding="UTF-8") as file:
            type_base = file.read()
            text += type_base

        class_text_template = ""
        with open("./templates/type_class.txt", encoding="UTF-8")as file:
            class_text_template = file.read()

        enum_text_template = ""
        with open("./templates/type_enum.txt", encoding="UTF-8") as file:
            enum_text_template = file.read()

        generic_text_template = ""
        with open("./templates/type_generic.txt", encoding="UTF-8") as file:
            generic_text_template = file.read()

        for type_name, type_def in self.TypeSpec.items():
            class_text = class_text_template
            enum_text = enum_text_template
            generic_text = generic_text_template

            fields = ""
            type_def_description = " * " + type_def.Description + "\n"

            if type_def.SpecialType == "Enum":
                for field in type_def.Fields:
                    if field.Name == "None":
                        field.Name = "None_"
                    field_text = f"    @SerializedName(\"{field.Value}\")\n    {field.Name}({field.Value}),\n"
                    fields += field_text

                    type_def_description += f" * {field.Name}: {field.Description}\n"

                if fields.endswith(",\n"):
                    fields = fields[:-2] + ";"

                if type_def_description.endswith("\n"):
                    type_def_description = type_def_description[:-1]

                enum_text = enum_text.replace("{TypeFields}", fields)
                enum_text = enum_text.replace("{TypeName}", type_name)
                enum_text = enum_text.replace("{TypeDescription}", type_def_description)

                text += enum_text

            elif type_def.SpecialType == "Generic":
                for field in type_def.Fields:
                    field.TypeName = self._convert_type(field.TypeName, field.Optional)

                    field_text = f"{field.TypeName} {field.Name}, "
                    type_def_description += f" * @param {field.Name} {field.Description}\n"
                    fields += field_text

                if type_def_description.endswith("\n"):
                    type_def_description = type_def_description[:-1]

                if fields.endswith(", "):
                    fields = fields[:-2]

                generic_text = generic_text.replace("{TypeFields}", fields)
                generic_text = generic_text.replace("{TypeName}", type_name)
                generic_text = generic_text.replace("{TypeDescription}", type_def_description)

                text += generic_text

            else:
                for field in type_def.Fields:
                    field.TypeName = self._convert_type(field.TypeName, field.Optional)

                    field_text = f"{field.TypeName} {field.Name}, "
                    type_def_description += f" * @param {field.Name} {field.Description}\n"
                    fields += field_text

                if type_def_description.endswith("\n"):
                    type_def_description = type_def_description[:-1]

                if fields.endswith(", "):
                    fields = fields[:-2]

                class_text = class_text.replace("{TypeFields}", fields)
                class_text = class_text.replace("{TypeName}", type_name)
                class_text = class_text.replace("{TypeDescription}", type_def_description)

                text += class_text

            with open(f"../src/main/java/dev/neuralnexus/ampapi/types/{type_name}.java", "w", encoding="UTF-8") as file:
                file.write(text)
                text = type_base

    def generate_plugins(self) -> None:
        text = ""
        plugin_base = ""
        with open("./templates/plugin_base.txt", encoding="UTF-8") as file:
            plugin_base = file.read()
            text += plugin_base

        plugin_class_template = ""
        with open("./templates/plugin_class.txt", encoding="UTF-8") as file:
            plugin_class_template = file.read()

        plugin_method_template = ""
        with open("./templates/plugin_method.txt", encoding="UTF-8") as file:
            plugin_method_template = file.read()

        for plugin_name, method_spec in self.APISpec.items():
            if plugin_name == "CommonCorePlugin":
                continue

            plugin_class = plugin_class_template
            plugin_methods = ""

            for method_name, method_def in method_spec.items():
                method_text = plugin_method_template

                parameter_text = ""
                payload_text = ""
                for param in method_def["Parameters"]:
                    param_text = f"{self._convert_type(param['TypeName'])} {param['Name']}"
                    payload_text += f"\n        args.put(\"{param['Name']}\", {param['Name']});"

                    if param.get("Optional"):
                        param_text = f"@Nullable {param_text}"

                    param_text += ", "
                    parameter_text += param_text

                if parameter_text != "":
                    parameter_text = parameter_text[:-2]

                parameter_args = ""
                for param in method_def["Parameters"]:
                    param_text = f"'{param['Name']}': {param['Name']}"

                    param_text += ", "
                    parameter_args += param_text

                if parameter_args != "":
                    parameter_args = "\n            " + parameter_args[:-2]
                    parameter_args = parameter_args.replace(", ", ",\n            ")
                    parameter_args += "\n        "

                parameter_docs = ""
                for param in method_def["Parameters"]:
                    parameter_docs += f"     * @param {param['Name']} {param['Description']}\n"

                if parameter_docs != "":
                    parameter_docs = parameter_docs[:-1]
                parameter_docs = parameter_docs + "\n    "

                method_text = method_text.replace("{MethodParameters}", parameter_text)
                method_text = method_text.replace("{MethodParameterAssignments}", payload_text)
                method_text = method_text.replace("{MethodParameterArgs}", parameter_args)
                method_text = method_text.replace("{MethodParameterDocs}", parameter_docs)
                method_text = method_text.replace("{MethodName}", method_name)
                if method_def.get("Description") is None:
                    method_def["Description"] = ""
                method_text = method_text.replace("{MethodDescription}", method_def.get("Description", ""))
                return_type = self._convert_type(method_def["ReturnTypeName"])
                method_text = method_text.replace("{ReturnType}", return_type)
                method_text = method_text.replace("{ReturnTypeDoc}", return_type.replace("<", "&lt;").replace(">", "&gt;"))

                plugin_methods += method_text

            async_plugin_methods = plugin_methods.replace("def ", "async def ").replace("json_to_obj(", "json_to_obj(await ")

            plugin_class = plugin_class.replace("{PluginMethods}", plugin_methods)
            plugin_class = plugin_class.replace("{AsyncPluginMethods}", async_plugin_methods)
            plugin_class = plugin_class.replace("{PluginName}", plugin_name)
            plugin_class = plugin_class[:-1]

            text += plugin_class

            # Adapt Void return type usages
#             text = text.replace("public Void ", "public void ")\
#                 .replace("* Name Description Optional\n     *\n\n     * @return Void\n     ", "")\
#                 .replace("* @return Void\n     ", "")
#             pattern = r"Type type = new TypeToken<Void>\(\) \{\}\.getType\(\);\s*\n        return (this\.APICall\([^,]+, [^,]+), type\);"
#             replacement = r"\1);"
#             text = re.sub(pattern, replacement, text)

            # Adapt arg-less methods
            pattern = (
                r"(\s*)Map<String, Object> args = new HashMap<>\(\);\s*"
                # Type type = new TypeToken<List<DeploymentTemplate>>() {}.getType();
                r"(\s*Type type = new TypeToken<[^>]+>\(\) \{\}\.getType\(\);)"
                r"(\s*)return (this\.APICall\([^,]+), args, (type\));"
            )
            replacement = r"\n        \2\3return \4, \5;"
            text = re.sub(pattern, replacement, text)

            pattern = (
                r"(\s*)Map<String, Object> args = new HashMap<>\(\);\s*"
                # Type type = new TypeToken<RemoteTargetInfo>() {}.getType();
                r"(\s*Type type = new TypeToken<[^>]+>>\(\) \{\}\.getType\(\);)"
                r"(\s*)return (this\.APICall\([^,]+), args, (type\));"
            )
            replacement = r"\n        \2\3return \4, \5;"
            text = re.sub(pattern, replacement, text)

            pattern = (
                r"(\s*)Map<String, Object> args = new HashMap<>\(\);\s*"
                r"(\s*)(this\.APICall\([^,]+), args\);"
            )
            replacement = r"\n        \2\3);"
            text = re.sub(pattern, replacement, text)

            with open(f"../src/main/java/dev/neuralnexus/ampapi/plugins/{plugin_name}.java", "w", encoding="UTF-8") as file:
                file.write(text)
                text = plugin_base

    def generate_modules(self) -> None:
        text = ""
        with open("./templates/module_base.txt", encoding="UTF-8") as file:
            text = file.read()

        module_class_template = ""
        with open("./templates/module_class.txt", encoding="UTF-8") as file:
            module_class_template = file.read()

        common_plugins = []
        for plugin_list in self.ModuleInheritance.values():
            for plugin in plugin_list:
                if plugin == "CommonCorePlugin":
                    continue
                for plugin_list2 in self.ModuleInheritance.values():
                    if plugin not in plugin_list2:
                        break
                else:
                    if plugin not in common_plugins:
                        common_plugins.append(plugin)

        for plugin_list in self.ModuleInheritance.values():
            for plugin in common_plugins:
                if plugin in plugin_list:
                    plugin_list.remove(plugin)
            plugin_list.remove("CommonCorePlugin")

        # Generate CommonAPI
        common_loaded_plugins = ""
        common_plugin_init = ""
        common_async_loaded_plugins = ""
        common_async_plugin_init = ""
        for plugin in common_plugins:
            common_loaded_plugins += f"    /** {plugin} plugin */\n    public final {plugin} {plugin};\n"
            common_plugin_init += f"        this.{plugin} = new {plugin}(authProvider);\n"
#             common_async_loaded_plugins += f"    {plugin} = Final[{plugin}Async]\n"
#             common_async_plugin_init += f"        self.{plugin} = {plugin}Async(self)\n"
        common_loaded_plugins = common_loaded_plugins[:-1]

        text = text.replace("{LoadedPlugins}", common_loaded_plugins)
        text = text.replace("{PluginInit}", common_plugin_init)
        text = text.replace("{LoadedPluginsAsync}", common_async_loaded_plugins)
        text = text.replace("{PluginInitAsync}", common_async_plugin_init)

        with open(f"../src/main/java/dev/neuralnexus/ampapi/modules/CommonAPI.java", "w", encoding="UTF-8") as file:
            file.write(text)
            text = ""

        # Generate module classes
        for module_name, plugin_list in self.ModuleInheritance.items():
            module_class = module_class_template

            module_loaded_plugins = ""
            module_plugin_init = ""
            async_module_loaded_plugins = ""
            async_module_plugin_init = ""
            for plugin in plugin_list:
                module_loaded_plugins += f"    /** {plugin} plugin */\n    public final {plugin} {plugin};\n"
                module_plugin_init += f"        this.{plugin} = new {plugin}(authProvider);\n"
#                 async_module_loaded_plugins += f"    {plugin} = Final[{plugin}Async]\n"
#                 async_module_plugin_init += f"        self.{plugin} = {plugin}Async(self)\n"

            module_loaded_plugins = module_loaded_plugins[:-1]

            module_class = module_class.replace("{LoadedPlugins}", module_loaded_plugins)
            module_class = module_class.replace("{PluginInit}", module_plugin_init)
            module_class = module_class.replace("{LoadedPluginsAsync}", async_module_loaded_plugins)
            module_class = module_class.replace("{PluginInitAsync}", async_module_plugin_init)
            module_class = module_class.replace("{ModuleName}", module_name)
            module_class = module_class[:-1]

            text += module_class + "\n"

            text = text[:-1]

            with open(f"../src/main/java/dev/neuralnexus/ampapi/modules/{module_name}.java", "w", encoding="UTF-8") as file:
                file.write(text)
                text = ""

    def generate(self) -> None:
        """Generate Code"""
        self.generate_types()
        self.generate_plugins()
        self.generate_modules()

if __name__ == "__main__":
    CodeGen().generate()
