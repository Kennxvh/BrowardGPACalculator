import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GradeDisplay extends JFrame {

    public GradeDisplay(){
        setTitle("Grade Calculator - Broward County Public Schools");
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1100,700);
        setLocationRelativeTo(null);
        setJMenuBar(new MenuBar());

        JPanel infoLabels = new JPanel(new FlowLayout(FlowLayout.LEFT));

        titleLabel tLabel = new titleLabel("Term", "Term 1 & Term 2 correspond to each semester - if adding an EOC/other year long course, please select Term 3.");
        titleLabel courseNameLabel = new titleLabel("Course Name", 150);
        titleLabel courseIDLabel = new titleLabel("Course ID", "Must be 8 digits long - See Schedule tab in Pinnacle or A10 CURRENT SCHEDULE panel for more information.", 150);
        titleLabel courseTypeLabel = new titleLabel("Course Designation",200);
        titleLabel creditAttemptedLabel = new titleLabel("Credit Attempted","Must be either 0.5 or 1.0 - will be determined based on term number selected. Do not enter 1.0 for a semester-long credit.",150);
        titleLabel creditEarnedLabel = new titleLabel("Credit Earned",150);
        titleLabel gradeEarnedLabel = new titleLabel("Grade",70);

        infoLabels.add(tLabel);
        infoLabels.add(courseNameLabel);
        infoLabels.add(courseIDLabel);
        infoLabels.add(courseTypeLabel);
        infoLabels.add(creditAttemptedLabel);
        infoLabels.add(creditEarnedLabel);
        infoLabels.add(gradeEarnedLabel);
        add(infoLabels);

        JPanel addInfo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        String[] termOptions = {"1","2","3"};
        JComboBox termDropdown = new JComboBox(termOptions);
        termDropdown.setPreferredSize(new Dimension(59,30));
        termDropdown.setSelectedIndex(0);
        JTextField courseName = new JTextField();
        courseName.setPreferredSize(new Dimension(150,30));
        JTextField courseID = new JTextField();
        courseID.setPreferredSize(new Dimension(150,30));
        String[] courseTypeOptions = {"Regular", "Honors", "AP", "AICE", "IB", "Dual"};
        JComboBox courseTypeDropdown = new JComboBox(courseTypeOptions);
        courseTypeDropdown.setPreferredSize(new Dimension(200,30));
        courseTypeDropdown.setSelectedIndex(0);
        String [] creditAttemptedOptions = {"0.5", "1.0"};
        JComboBox creditAttemptedDropdown = new JComboBox(creditAttemptedOptions);
        creditAttemptedDropdown.setPreferredSize(new Dimension(150,30));
        creditAttemptedDropdown.setSelectedIndex(0);
        String [] creditEarnedOptions = {"0","0.5","1.0"};
        JComboBox creditEarnedDropdown = new JComboBox(creditEarnedOptions);
        creditEarnedDropdown.setPreferredSize(new Dimension(150,30));
        creditEarnedDropdown.setSelectedIndex(0);
        String [] gradeOptions = {"A", "B+", "B", "C+", "C", "D+", "D", "F", "I"};
        JComboBox gradeDropdown = new JComboBox(gradeOptions);
        gradeDropdown.setPreferredSize(new Dimension(70,30));
        gradeDropdown.setSelectedIndex(0);
        JButton submitInfo = new JButton("Add");
        submitInfo.setPreferredSize(new Dimension(50,30));

        addInfo.add(termDropdown);
        addInfo.add(courseName);
        addInfo.add(courseID);
        addInfo.add(courseTypeDropdown);
        addInfo.add(creditAttemptedDropdown);
        addInfo.add(creditEarnedDropdown);
        addInfo.add(gradeDropdown);
        addInfo.add(submitInfo);
        add(addInfo);

        JPanel scrollPanel = new JPanel();
        scrollPanel.setPreferredSize(new Dimension(1100,500));
        String columnHeaders[] = {"Term", "Course Name", "Course ID", "Course Designation", "Credit Attempted", "Credit Earned", "Grade"};
        String testData[][] = {{"1","AICE MARINE SCI 1 AS", "20025150", "AICE", "0.5", "0.5", "A"}, {"2","AICE MARINE SCI 1 AS", "20025150", "AICE", "0.5", "0.5", "A"}};
        JTable infoTable = new JTable(testData,columnHeaders);
        infoTable.setPreferredSize(new Dimension(1040,460));
        infoTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JScrollPane infoScrollPane = new JScrollPane(infoTable);
        infoScrollPane.setPreferredSize(new Dimension(1060,460));
        scrollPanel.add(infoScrollPane);
        add(scrollPanel);

        JPanel bottomBar = new JPanel();
        JLabel textUnweightedGPA = new JLabel("<html><b>Unweighted: </b>");
        JLabel valueUnweightedGPA = new JLabel("0.00");
        JLabel textWeightedGPA = new JLabel("<html><b>Weighted: </b>");
        JLabel valueWeightedGPA = new JLabel("0.00");
        JSeparator divider = new JSeparator();
        bottomBar.setBorder(new BevelBorder(BevelBorder.LOWERED));
        add(bottomBar, BorderLayout.SOUTH);
        bottomBar.setPreferredSize(new Dimension(getWidth(), 30));
        bottomBar.setLayout(new BoxLayout(bottomBar, BoxLayout.X_AXIS));
        textUnweightedGPA.setHorizontalAlignment(SwingConstants.LEFT);
        valueUnweightedGPA.setHorizontalAlignment(SwingConstants.LEFT);
        textWeightedGPA.setHorizontalAlignment(SwingConstants.LEFT);
        divider.setOrientation(SwingConstants.VERTICAL);
        textWeightedGPA.setHorizontalAlignment(SwingConstants.LEFT);
        bottomBar.add(textUnweightedGPA);
        bottomBar.add(valueUnweightedGPA);
        bottomBar.add(divider);
        bottomBar.add(textWeightedGPA);
        bottomBar.add(valueWeightedGPA);

        setVisible(true);
    }

    public static void main(String args []){
        new GradeDisplay();
    }
}

class MenuBar extends JMenuBar{
    JMenu fileMenu = new JMenu("File");
    JMenu optionsMenu = new JMenu("Options");
    JMenu helpMenu = new JMenu("Help");
    JMenuItem policyHelp = new JMenuItem("Policy 4000");
    MenuBar() {
        policyHelp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Desktop.getDesktop().browse(java.net.URI.create("https://web01.browardschools.com/sbbcpolicies/docs/Policy%204000.pdf"));
                }
                catch(Exception e2){
                    e2.printStackTrace();
                }
            }
        });
        helpMenu.add(policyHelp);
        add(fileMenu);
        add(optionsMenu);
        add(helpMenu);
    }
}

class titleLabel extends JLabel{
    titleLabel(String title){
        setText(title);
        setHorizontalAlignment(SwingConstants.CENTER);
        setPreferredSize(new Dimension(50,30));
        setFont(new Font("Century Gothic", Font.BOLD, 15));
        setOpaque(true);
        setBackground(new java.awt.Color(148, 177, 224));
    }

    titleLabel(String title, String toolTip){
        setText(title);
        setHorizontalAlignment(SwingConstants.CENTER);
        setPreferredSize(new Dimension(50,30));
        setFont(new Font("Century Gothic", Font.BOLD, 15));
        setOpaque(true);
        setBackground(new java.awt.Color(148, 177, 224));
        setToolTipText(toolTip);
    }

    titleLabel(String title, int width){
        setText(title);
        setHorizontalAlignment(SwingConstants.CENTER);
        setPreferredSize(new Dimension(width,30));
        setFont(new Font("Century Gothic", Font.BOLD, 15));
        setOpaque(true);
        setBackground(new java.awt.Color(148, 177, 224));
    }

    titleLabel(String title, String toolTip, int width) {
        setText(title);
        setHorizontalAlignment(SwingConstants.CENTER);
        setPreferredSize(new Dimension(width, 30));
        setFont(new Font("Century Gothic", Font.BOLD, 15));
        setOpaque(true);
        setBackground(new java.awt.Color(148, 177, 224));
        setToolTipText(toolTip);
    }
}