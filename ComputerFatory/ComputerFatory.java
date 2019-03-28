//反射与简单工厂
interface IComputer{
 void buyComputer();
}
class Macbook implements IComputer{

    @Override
    public void buyComputer() {
        System.out.println("买一台苹果电脑");
    }
}


class Surface implements IComputer{

    @Override
    public void buyComputer() {
        System.out.println("买一台微软电脑");
    }
}
class AlienWare implements IComputer{
    @Override
    public void buyComputer() {
        System.out.println("买一台外星人电脑");
    }
}

//反射与简单工厂


public class ComputerFatory {
    public static IComputer getInstance(String computerClass) {
        try {
            Class<?> cls = Class.forName(computerClass);
            IComputer computer =
                    (IComputer) cls.newInstance();
            return computer;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }
}


public class Test {

    public static void main(String[] args) throws Exception {
        IComputer iComputer = ComputerFatory.getInstance("com.bite.JavaSE.bite.AlienWare");
        iComputer.buyComputer();
    }
}
