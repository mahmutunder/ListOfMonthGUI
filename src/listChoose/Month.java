package listChoose;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Month extends JFrame {
    private JPanel monthPanel;
    private JPanel showPanel;
    private JPanel buttonPanel;

    private JList showList;
    private JList chooseList;

    private JScrollPane sList;
    private JScrollPane cList;
    private String[] months = { "January", "February",
            "March", "April", "May", "June", "July",
            "August", "September", "October", "November",
            "December" };
    private JButton getSelected;

    public Month(){

      setTitle("Months");
      setLayout(new BorderLayout());

      setDefaultCloseOperation(3);

      buildShowMonth();
      buildChooseMonth();
      buildButtonMonth();
      add(showPanel, BorderLayout.NORTH);
      add(chooseList,BorderLayout.CENTER);
      add(buttonPanel, BorderLayout.SOUTH);
      setSize(400,400);


      setVisible(true);




    }

    private void buildButtonMonth() {
        getSelected= new JButton("Get Selected");
        getSelected.addActionListener(new GetChoose());
        buttonPanel= new JPanel();
        buttonPanel.add(getSelected);
    }

    private void buildChooseMonth() {
        chooseList= new JList();
        showPanel= new JPanel();
        cList= new JScrollPane(showList);
        showPanel.add(cList);


    }

    private void buildShowMonth() {
        monthPanel = new JPanel();
        showList= new JList(months);
        sList= new JScrollPane(showList);
        showList.setVisibleRowCount(6);
        showList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
       monthPanel.add(sList);



    }

    public static void main(String[] args) {
        new Month();
    }


    private class GetChoose implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            Object[] selectedList=showList.getSelectedValues();
            chooseList.setListData(selectedList);

        }
    }
}
