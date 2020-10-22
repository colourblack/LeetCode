package another.num690;

import java.util.List;

public class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Employee root = null;
        for(Employee e : employees) {
            if(e.id == id) {
                root = e;
            }
        }

        int importance = root.importance;
        for(int sub : root.subordinates) {
            importance += getImportance(employees, sub);
        }
        return importance;
    }
}
