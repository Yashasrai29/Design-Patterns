package abstract_factory.ios;

import abstract_factory.Button;

public class IosButton implements Button {
    @Override
    public void hit() {
        System.out.println("hitting ios button");
    }
}
