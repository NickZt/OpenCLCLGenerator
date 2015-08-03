/*
   OpenCL CL files header Generator for Android NDK
   Copyright (c) 2006-2015 SIProp Project http://www.siprop.org/
   This software is provided 'as-is', without any express or implied warranty.
   In no event will the authors be held liable for any damages arising from the use of this software.
   Permission is granted to anyone to use this software for any purpose,
   including commercial applications, and to alter it and redistribute it freely,
   subject to the following restrictions:
   1. The origin of this software must not be misrepresented; you must not claim that you wrote the original software. If you use this software in a product, an acknowledgment in the product documentation would be appreciated but is not required.
   2. Altered source versions must be plainly marked as such, and must not be misrepresented as being the original software.
   3. This notice may not be removed or altered from any source distribution.
*/
package org.siprop.android.opencl;

import com.intellij.openapi.components.*;
import com.intellij.openapi.project.Project;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.Nullable;

@State(
        name = "OpenCLCLGeneratorPluginConfig",
        storages = {
                @Storage(
                        id = "other",
                        file = "$APP_CONFIG$/openclclgenerator_plugin.xml")
        }
)
public class PluginConfig implements PersistentStateComponent<PluginConfig> {


    public String JNIPath = OpenCLCLGenerator.DEFAULT_JNI_PATH;
    public String GeneratedHeaderName = OpenCLCLGenerator.DEFAULT_HEADER_NAME;
    public String Prefix4Variable = OpenCLCLGenerator.DEFAULT_PREFIX_CL;


    @Nullable
    @Override
    public PluginConfig getState() {
        return this;
    }

    @Override
    public void loadState(PluginConfig config) {
        XmlSerializerUtil.copyBean(config, this);
    }

    @Nullable
    public static PluginConfig getInstance(Project project) {
        return ServiceManager.getService(project, PluginConfig.class);
    }

}
