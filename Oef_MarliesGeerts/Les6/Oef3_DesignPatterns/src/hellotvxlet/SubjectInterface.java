package hellotvxlet;

public interface SubjectInterface {
    public abstract void Register(ObserverInterface ob);
    public abstract void Unregister(ObserverInterface ob);
}
