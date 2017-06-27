package com.flylinran.plugin;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;

/**
 * author: Flyli
 * date: 2017/6/27
 * description:
 */
public class KeyAction extends AnAction {

    @Override
    public void update(AnActionEvent e) {
        e.getPresentation().setEnabled(true);
    }

    @Override
    public void actionPerformed(AnActionEvent e) {
//        Project project = e.getData(PlatformDataKeys.PROJECT);
//        Messages.showMessageDialog(project,
//                "Hello World!",
//                "Information",
//                Messages.getInformationIcon());
    }
}
