package application.interfaces;

public interface Visitable {

    Double accept(Visitor visitor);
}
