package design_patterns.adapter_exercise;

public class PensionerAdapter{
    private Pensioner pensioner;

    public PensionerAdapter(String name, int age){
        pensioner = new Pensioner(name, age);
    }

    @Override
    public String toString() {
        return pensioner.getInfo();
    }
}
