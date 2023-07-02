package ro.sda.spring.proxy_pattern;

public class MathServiceProxy extends MathService {

    private MathService mathService;

    public MathServiceProxy() {
        this.mathService = new MathService();
    }

    @Override
    public int add(int a, int b) {
        System.out.println("BEFORE");
        try{
            return this.mathService.add(a, b);
        } catch(RuntimeException ex){
            System.out.println("AFTER THROWING");
        } finally {
            System.out.println("AFTER");
        }
        return 0;
    }

    @Override
    public int subtract(int a, int b) {
        System.out.println("BEFORE");
        try{
            return this.mathService.subtract(a, b);
        } catch(RuntimeException ex){
            System.out.println("AFTER THROWING");
        } finally {
            System.out.println("AFTER");
        }
        return 0;
    }
}
