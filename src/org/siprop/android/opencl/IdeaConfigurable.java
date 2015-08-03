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

import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.options.Configurable;

import javax.swing.*;

public class IdeaConfigurable  implements Configurable {

    private JPanel myPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;

    final PluginConfig config = ServiceManager.getService(PluginConfig.class);

    public String getDisplayName() {
        return "OpenCL CL files header Generator For IDEA";
    }

    public boolean isModified() {
        return true;
    }

    private void setFromConfig() {
        textField1.setText(config.JNIPath);
        textField2.setText(config.GeneratedHeaderName);
        textField3.setText(config.Prefix4Variable);
    }

    public JComponent createComponent() {
        setFromConfig();
        return myPanel;

    }

    public void apply() {
        if (!isModified()) {
            return;
        }

        config.JNIPath = textField1.getText();
        config.GeneratedHeaderName = textField2.getText();
        config.Prefix4Variable = textField3.getText();
    }

    public void disposeUIResources() {
        myPanel.removeAll();
        myPanel.getParent().remove(myPanel);
    }

    public String getHelpTopic() {
        return "preferences.topic";
    }

    public void reset() {
        setFromConfig();
    }


}
