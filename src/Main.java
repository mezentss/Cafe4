abstract class Beverage {
    String description = "Unknown Beverage";
    double volume = 0.4; // по умолчанию объем 0.4л

    public String getDescription() {
        return description;
    }

    public abstract int cost();

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getVolume() {
        return volume;
    }
}

class Tea extends Beverage {
    public Tea() {
        description = "Чай";
    }

    public int cost() {
        return (int) (100 / volume);
    }
}

class Mocktail extends Beverage {
    public Mocktail() {
        description = "Безалкогольный коктейль";
    }

    public int cost() {
        return (int) (200 / volume);
    }
}

class Fresh extends Beverage {
    public Fresh() {
        description = "Фруктовый фреш";
    }

    public int cost() {
        return (int) (150 / volume);
    }
}
class Raf extends Beverage {
    public Raf() {
        description = "Раф";
    }
    public int cost() {
        return (int) (250 / volume);
    }
}

class Latte extends Beverage {
    public Latte() {
        description = "Латте";
    }
    public int cost() {
        return (int) (150 / volume);
    }
}

class Espresso extends Beverage {
    public Espresso() {
        description = "Эспрессо";
    }
    public int cost() {
        return (int) (180 / volume);
    }
}

class Cappuccino extends Beverage {
    public Cappuccino() {
        description = "Каппучино";
    }
    public int cost() {
        return (int) (155 / volume);
    }
}

abstract class BeverageFactory {
    public abstract Beverage createBeverage();
}

class TeaFactory extends BeverageFactory {
    public Beverage createBeverage() {
        return new Tea();
    }
}

class MocktailFactory extends BeverageFactory {
    public Beverage createBeverage() {
        return new Mocktail();
    }
}

class FreshFactory extends BeverageFactory {
    public Beverage createBeverage() {
        return new Fresh();
    }
}

class EspressoFactory extends BeverageFactory {
    public Beverage createBeverage() {
        return new Espresso();
    }
}

class RafFactory extends BeverageFactory {
    public Beverage createBeverage() {
        return new Raf();
    }
}

class CappuccinoFactory extends BeverageFactory {
    public Beverage createBeverage() {
        return new Cappuccino();
    }
}


//Декоратор
abstract class FlavoringDecorator extends Beverage {
    public abstract String getDescription();
}

class Whip extends FlavoringDecorator {
    Beverage beverage;
    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }
    public String getDescription() {
        return beverage.getDescription() + ", Взбитые сливки";
    }
    public int cost() {
        return beverage.cost() + 50;
    }
}

class Milk extends FlavoringDecorator {
    Beverage beverage;
    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }
    public String getDescription() {
        return beverage.getDescription() + ", Молоко";
    }
    public int cost() {
        return beverage.cost() + 40;
    }
}

class Soy extends FlavoringDecorator {
    Beverage beverage;
    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }
    public String getDescription() {
        return beverage.getDescription() + ", Соя";
    }
    public int cost() {
        return beverage.cost() + 45;
    }
}

class Choco extends FlavoringDecorator {
    Beverage beverage;
    public Choco(Beverage beverage) {
        this.beverage = beverage;
    }
    public String getDescription() {
        return beverage.getDescription() + ", Шоколад";
    }
    public int cost() {
        return beverage.cost() + 50;
    }
}

public class Main {
    public static void main(String[] args) {
        BeverageFactory cappuccinoFactory = new CappuccinoFactory();
        Beverage cappuccino = cappuccinoFactory.createBeverage();
        cappuccino.setVolume(0.6);
        cappuccino = new Milk(cappuccino);
        cappuccino = new Choco(cappuccino);
        System.out.println("Заказан напиток: " + cappuccino.getDescription() + ", объем: " + cappuccino.getVolume() + "л");
        System.out.println("Общая стоимость: " + cappuccino.cost());

        BeverageFactory freshFactory = new FreshFactory();
        Beverage fresh = freshFactory.createBeverage();
        fresh.setVolume(0.8);
        System.out.println("Заказан напиток: " + fresh.getDescription() + ", объем: " + fresh.getVolume() + "л");
        System.out.println("Общая стоимость: " + fresh.cost());
    }
}