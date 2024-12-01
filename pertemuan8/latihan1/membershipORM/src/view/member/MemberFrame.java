package view.member;  

import javax.swing.JButton;  
import javax.swing.JComboBox;  
import javax.swing.JFrame;  
import javax.swing.JLabel;  
import javax.swing.JOptionPane;  
import javax.swing.JScrollPane;  
import javax.swing.JTable;  
import javax.swing.JTextField;    
import java.util.List;  
import model.JenisMember;  
import model.Member;  
import dao.MemberDao;  
import dao.JenisMemberDao;  

public class MemberFrame extends JFrame {  
    private List<JenisMember> jenisMemberList;  
    private List<Member> memberList;  
    private JTextField textFieldNama;  
    private MemberTableModel tableModel;  
    private JComboBox<String> comboJenis;  
    private MemberDao memberDao;  
    private JenisMemberDao jenisMemberDao;  

    public MemberFrame(MemberDao memberDao, JenisMemberDao jenisMemberDao) {  
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
        this.memberDao = memberDao;  
        this.jenisMemberDao = jenisMemberDao;  
        this.memberList = this.memberDao.findAll();  
        this.jenisMemberList = this.jenisMemberDao.findAll();  

        JLabel labelInput = new JLabel("Nama:");  
        labelInput.setBounds(15, 40, 350, 10);  

        textFieldNama = new JTextField();  
        textFieldNama.setBounds(15, 60, 350, 20);  

        JLabel labelJenis = new JLabel("Jenis Member:");  
        labelJenis.setBounds(15, 100, 100, 20);  

        comboJenis = new JComboBox<>();  
        comboJenis.setBounds(15, 120, 200, 20);  

        JButton button = new JButton("Simpan");  
        button.setBounds(15, 150, 80, 30);  

        this.add(labelInput);  
        this.add(textFieldNama);  
        this.add(labelJenis);  
        this.add(comboJenis);  
        this.add(button);  

        this.setSize(400, 500);  
        this.setLayout(null);  

        javax.swing.JTable table = new JTable();  
        JScrollPane scrollableTable = new JScrollPane(table);  
        scrollableTable.setBounds(15, 220, 250, 200);  

        tableModel = new MemberTableModel(memberList);  
        table.setModel(tableModel);  

        MemberButtonSimpanActionListener actionListener = new MemberButtonSimpanActionListener(this, memberDao);  
        button.addActionListener(actionListener);  

        this.add(scrollableTable);  
    }  

    public void populateComboJenis() {  
        this.jenisMemberList = this.jenisMemberDao.findAll();  
        comboJenis.removeAllItems();  
        for (JenisMember jenisMember : this.jenisMemberList) {  
            comboJenis.addItem(jenisMember.getNama());  
        }  
    }  

    public String getNama() {  
        return textFieldNama.getText();  
    }  

    public JenisMember getJenisMember() {  
        return jenisMemberList.get(comboJenis.getSelectedIndex());  
    }  

    public void addMember(Member member) {  
        tableModel.add(member);  
        textFieldNama.setText("");  
    }  

    public void showAlert(String message) {  
        JOptionPane.showMessageDialog(this, message);  
    }  
}