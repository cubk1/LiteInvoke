import us.cubk.liteinvoke.LiteInvoke;

public class Main {
    public static void main(String[] args) throws Exception {
        LiteInvoke liteInvoke = new LiteInvoke();

        MyModule mod = new MyModule();
        OtherModule otherModule = new OtherModule();

        liteInvoke.registerBean(otherModule,mod); // Register

        CoolModule coolModule = liteInvoke.createInstance(CoolModule.class); // Constructor with parameter

        liteInvoke.autoWired(mod); // write field

        liteInvoke.invokeMethod(null,Main.class.getDeclaredMethod("call", MyModule.class));
        liteInvoke.invokeMethod(null,Main.class.getDeclaredMethod("call2",String.class, MyModule.class),"Hello!"); // The first parameter is known, for eventbus, etc
    }

    private static void call(MyModule module){
        module.callModule();
    }

    private static void call2(String sb,MyModule module){
        System.out.println(sb);
        module.callModule();
    }
}
