package lectures._15.generic;

public class Example2<TObject>
{
    private TObject object;

    public Example2(TObject object) {
        this.object = object;
    }

    public TObject getObject() {
        return this.object;
    }

}
