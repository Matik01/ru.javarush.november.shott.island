package animals;

import resources.AnimalSetting;

public abstract class Animal {
    public abstract void move();
    public abstract void reproduce();
    public abstract void dying();
    public abstract AnimalSetting getBaseSetting();

}
