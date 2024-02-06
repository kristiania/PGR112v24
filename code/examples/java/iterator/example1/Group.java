package examples.java.iterator.example1;

import java.util.ArrayList;
import java.util.Iterator;

public class Group implements Iterable<Member> {
    private final ArrayList<Member> members = new ArrayList<>();


    public void addMember(Member member) {
        this.members.add(member);
    }

    public void removeMember(Member member) {
        this.members.remove(member);
    }

    @Override
    public Iterator<Member> iterator() {
        return this.members.iterator();
    }
}
