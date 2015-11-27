import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.LangDataKeys;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiJavaFile;
import com.intellij.psi.PsiMethod;

/**
 * Created by pip on 27.11.2015.
 */
public class findPatterns extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {

        try {
            Project project = e.getData(PlatformDataKeys.PROJECT);
            PsiFile psi = e.getData(LangDataKeys.PSI_FILE);
            if (psi instanceof PsiJavaFile){
                checkFile(project, (PsiJavaFile) psi);
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }



//        PsiManager psiman = PsiManager.getInstance(project);
//
//        JavaPsiFacade facade=JavaPsiFacade.getInstance(project);
//
//        PsiJavaParserFacade parserFacade = facade.getParserFacade();

    }
    public void checkFile(Project project, PsiJavaFile file) {
        for (PsiClass clazz : file.getClasses()){
            for (PsiMethod method : clazz.getMethods()){
                System.out.println(method.getBody().getFirstBodyElement().getText());
            }
        }
    }
}
