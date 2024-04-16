import us.cubk.liteinvoke.LiteInvoke;

public class MyModule {
    @LiteInvoke.Autowired private OtherModule module;

    public void callModule(){
        System.out.println(module.getClass().getName());
    }
}
