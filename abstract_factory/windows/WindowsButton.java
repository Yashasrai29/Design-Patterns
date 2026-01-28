package abstract_factory.windows;

import abstract_factory.Button;

public class WindowsButton implements Button {
    @Override
    public void hit() {
        System.out.println("hitting windows button");
    }
}
