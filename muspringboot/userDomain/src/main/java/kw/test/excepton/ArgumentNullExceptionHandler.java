package kw.test.excepton;

/**
 * auther   kangwang
 */
public class ArgumentNullExceptionHandler {
    public static void checkArgument(Object object) {
        if(object == null) {
            try{
                throw new ArgumentNullException("参数异常！");
            }catch (ArgumentNullException e) {
                e.printStackTrace();
            }
        }
    }
}

