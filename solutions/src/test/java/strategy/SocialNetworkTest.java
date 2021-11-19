package strategy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SocialNetworkTest {

    @Test
    void createMember() {
        Member member = new Member("John Doe", List.of("Java", "OOP"));
        assertEquals("John Doe", member.getName());
        assertEquals(List.of("Java", "OOP"), member.getSkills());
    }

    @Test
    void testFindMembersBy() {
        SocialNetwork socialNetwork = new SocialNetwork(List.of(
           new Member("John Doe", List.of("Java", "OOP")),
           new Member("Jane Doe", List.of(".NET", "OOP")),
           new Member("James Doe", List.of("Python", "Java", "OOP")),
           new Member("Janet Doe", List.of("JavaScript", "scripting"))
        ));

        List<Member> found = socialNetwork.findMembersBy(m -> m.getSkills().contains("Java"));
        assertEquals(2, found.size());
        assertEquals("John Doe", found.get(0).getName());
        assertEquals("James Doe", found.get(1).getName());
    }

    @Test
    void testApplyToSelectedMembers() {
        SocialNetwork socialNetwork = new SocialNetwork(List.of(
                new Member("John Doe", List.of("Java", "OOP")),
                new Member("Jane Doe", new ArrayList<>(List.of(".NET", "OOP"))),
                new Member("James Doe", List.of("Python", "Java", "OOP")),
                new Member("Janet Doe", new ArrayList<>(List.of("JavaScript", "scripting")))
        ));

        socialNetwork.applyToSelectedMembers(m -> m.getName().startsWith("Jane"), m -> m.getSkills().add("Design Patterns"));

        assertEquals(List.of(".NET", "OOP", "Design Patterns"), socialNetwork.findMembersBy(m -> m.getName().equals("Jane Doe")).get(0).getSkills());

        assertEquals(List.of("Java", "OOP"), socialNetwork.findMembersBy(m -> m.getName().equals("John Doe")).get(0).getSkills());

        assertEquals(List.of("JavaScript", "scripting", "Design Patterns"), socialNetwork.findMembersBy(m -> m.getName().equals("Janet Doe")).get(0).getSkills());


    }

}
