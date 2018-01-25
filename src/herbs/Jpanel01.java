package herbs;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;

class Jpanel01 extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField textFieldName;	
	private JTextField textFieldMobile;
	private List<Appointment> appointmentList;
	private DefaultListModel<String> listModel;	
	private FileOutputStream fOutput;
	private ObjectOutputStream oOutput;
	private FileInputStream fInput;
	private ObjectInputStream oInput;
	JScrollPane scrollPane;
	JTextArea textArea;
	String[] timeArray = {"10:00","10:15","10:30","10:45","11:00","11:15","11:30","11:45","12:00",
			"12:15","12:30","12:45","13:00","13:15","13.30","13:45","14:00","14:15","14:30","14:45",
			"15:00","15:15","15:30","15:45","16:00","16:15","16:30","16:45","17:00","17:15","17:30","17:45"};
	String[] statusArray = {"Waiting","Cancelled","Arrived"};
	@SuppressWarnings("rawtypes")
	JComboBox comboBoxDay,comboBoxTime,comboBoxStatus;
	String[] dayArray;
	JTabbedPane tabbedPane;
	String appointmentID=" ";
	
	@SuppressWarnings("unchecked")
	public Jpanel01()  {
		setLayout(null);
		
		File theDir = new File("c:\\herbs");
		if (!theDir.exists()) {		    
		    boolean result = false;
		    try{
		        theDir.mkdir();
		        result = true;
		    } 
		    catch(SecurityException se){		       
		    }       
		   
		}
		
		//appointmentList = new ArrayList<Appointment>();
		//------------------------------------------------read from file is any
		try {
			fInput = new FileInputStream(new File("c:\\herbs\\herbsfile.txt"));
			oInput = new ObjectInputStream(fInput);
			appointmentList = (List<Appointment>) oInput.readObject();
			fInput.close();
			oInput.close();
		} catch (Exception e1) {			
			e1.printStackTrace();
		}
		
		Iterator<Appointment> it = appointmentList.iterator();
		while(it.hasNext()){
			Appointment each = it.next();
			String appointmentDay = each.getDay();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd, EEE");
			boolean isExpiredAppointment = false;
			try {
				Date appointmentDate = sdf.parse(appointmentDay);
				Date todayDate = new Date();
				long diff = appointmentDate.getTime() - new Date().getTime();
				//long diff = appointmentDate.getTime() - sdf.parse(sdf.format(new Date())).getTime();
				int diffDays = (int) diff/(24*60*60*1000) ;
				
				
				if( diffDays < -30){
					isExpiredAppointment = true;
					System.out.println("line 104: too old" + (int)diff);
				}			
			} catch (ParseException e) {				
				e.printStackTrace();
			}		
			
			if(each.getStatus().equals("Cancelled") || isExpiredAppointment){
				it.remove();
				System.out.println("line 112: removed too old");
			}
			
		}
		
//		for(Appointment each : appointmentList){
//			
//			String appointmentDay = each.getDay();
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd, EEE");
//			boolean isExpiredAppointment = false;
//			try {
//				Date appointmentDate = sdf.parse(appointmentDay);
//				Date todayDate = new Date();
//				long diff = appointmentDate.getTime() - sdf.parse(sdf.format(new Date())).getTime();
//				if(diff> 1000*60*60*24*30){
//					isExpiredAppointment = true;
//				}			
//			} catch (ParseException e) {				
//				e.printStackTrace();
//			}		
//			
//			if(each.getStatus().equals("Cancelled") || isExpiredAppointment){
//				appointmentList.remove(each);
//			}
//		}
		
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(14, 10, 46, 27);
		add(lblNewLabel);		
		
		textFieldName = new JTextField();
		textFieldName.setBounds(78, 13, 113,23);
		add(textFieldName);
		textFieldName.setColumns(10);				
				
		JLabel lblNewLabel_2 = new JLabel("Mobile");
		lblNewLabel_2.setBounds(14, 51, 54, 15);
		add(lblNewLabel_2);
		
		textFieldMobile = new JTextField();
		textFieldMobile.setBounds(78, 48, 113,23);
		add(textFieldMobile);
		textFieldMobile.setColumns(10);		
		
		dayArray = this.getDayArray();
		comboBoxDay = new JComboBox(dayArray);
		comboBoxDay.setBounds(78, 104, 113, 23);
		add(comboBoxDay);		
		
		comboBoxTime = new JComboBox(timeArray);
		comboBoxTime.setBounds(78, 137,113,23);
		add(comboBoxTime);		
		
		comboBoxStatus = new JComboBox(statusArray);
		comboBoxStatus.setBounds(78, 170, 113, 23);
		add(comboBoxStatus);
		
		JLabel lblDay = new JLabel("Day");
		lblDay.setBounds(14, 108, 54, 15);
		add(lblDay);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setBounds(14, 141, 54, 15);
		add(lblTime);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(14, 174, 54, 15);
		add(lblStatus);	
		
		JLabel lblNewLabel_1 = new JLabel("Note");
		lblNewLabel_1.setBounds(14, 206, 54, 15);
		add(lblNewLabel_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(14, 231, 219, 113);
		add(scrollPane_1);
		
		textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);		
		
		//--------------------------------------------------SAVE button
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setBounds(14, 411, 219, 25);		
		btnNewButton.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			  int indexDay = comboBoxDay.getSelectedIndex();
			  int indexTime = comboBoxTime.getSelectedIndex() ;
			  int indexStatus = comboBoxStatus.getSelectedIndex();
			  String name = textFieldName.getText();
			  String mobile = textFieldMobile.getText();
			  String note = textArea.getText();
			  
			  Calendar cal = Calendar.getInstance();
			  DateFormat dateFormat = new SimpleDateFormat("yyyy MMM dd, EEE");
			  cal.add(Calendar.DATE, indexDay); // convert selected day to date.			
			  String[] detail = {" ",name,mobile,dateFormat.format(cal.getTime()),timeArray[indexTime],statusArray[indexStatus],note};
			  Appointment newAppointment = new Appointment(detail);		
			
			  //----------------------------------changed old status to cancelled
			  if(appointmentID.length()>1){
				  for(Appointment each: appointmentList){
					 
					  if(each.getId().equals(appointmentID)){
						each.setStatus("Cancelled"); 
						appointmentList.remove(each);
						break;
					  }
				  }//end for
			  }//end if
			  
			  resetAllField();
			  appointmentList.add(newAppointment);
			  
			  //----------------------------------------------------save to a file			
				try {
					fOutput = new FileOutputStream(new File("c:\\herbs\\herbsfile.txt"));
					oOutput = new ObjectOutputStream(fOutput);
					oOutput.writeObject(appointmentList);
					oOutput.close();
					fOutput.close();
				} catch (Exception e1) {			
					e1.printStackTrace();
				}
			  
			  // scrollPane.setViewportView( createList() );			  
			  tabbedPane.removeAll();
			  for(int i=0; i<10; i++){
					tabbedPane.addTab(dayArray[i], makeScrollPane(i));			
			  }	
			  
		  }
		});
		add(btnNewButton);	
		//-------------------------------------------------------------clear button
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(14, 369, 219, 25);
		btnClear.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e)
			  {
				  resetAllField();
			  }
		});
		add(btnClear);
		
		//---------------------------------------------this is the tabbed pane to show all appointment
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(260, 10, 850, 426);	
		add(tabbedPane);		
		
		for(int i=0; i<10; i++){
			tabbedPane.addTab(dayArray[i], makeScrollPane(i));			
		}		
		 
	    tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);	
	    
//		//---------------------------------------------start Scrollpane()
//		scrollPane = new JScrollPane();
//		scrollPane.setBounds(855, 467, 250, 250);
//		add(scrollPane);
//
//		scrollPane.setViewportView( createList() );
		
	}//end constructor
	
	//--------------------------------------------------return panel for appointments on the day 
	private JScrollPane makeScrollPane(int i){
		
		DefaultListModel<String> lm = new DefaultListModel<String>();
		for(Appointment each:appointmentList){
			String appointmentDay = each.getDay();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd, EEE");
			try {
				Date appointmentDate = sdf.parse(appointmentDay);
				Date todayDate = new Date();
				long diff = appointmentDate.getTime() - sdf.parse(sdf.format(new Date())).getTime();
				int diffDays = (int) diff/(24*60*60*1000) ;
				if (i == diffDays && !each.getStatus().equals("Cancelled")){					
					lm.addElement(each.toString());
				}				
			} catch (ParseException e) {				
				e.printStackTrace();
			}
		}		
		
		//sort by appointment time
		Collection col = Collections.list(lm.elements());
		Collections.sort((List<String>) col);
		lm.clear();
		for(Object s:col){
			lm.addElement((String) s);			
		}
		
		JList list = new JList(lm);		
		list.setFont(new Font("monospaced", Font.PLAIN,12));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane jsp = new JScrollPane(list);
		
		//------------------------------------------------------------double click on list
		MouseListener mouseListener = new MouseAdapter() {
		      public void mouseClicked(MouseEvent mouseEvent) {
		        JList theList = (JList) mouseEvent.getSource();
		        if (mouseEvent.getClickCount() == 2) {
		          int index = theList.locationToIndex(mouseEvent.getPoint());
		          if (index >= 0) {
		            Object o = theList.getModel().getElementAt(index);		         
		            String selected =  o.toString();
		            String id = o.toString().substring( selected.length()-6 );		           
		            
		            for(Appointment each: appointmentList){
		            	if(each.getId().equals(id)){
		            		appointmentID = each.getId();		            		
		            		textFieldName.setText(each.getName());
		            		textFieldMobile.setText(each.getMobile());
		            		textArea.setText(each.getNote());
		            		for(int i=0; i<timeArray.length; i++){
		            			if(timeArray[i].equals(each.getTime())){
		            				comboBoxTime.setSelectedIndex(i);
		            				break;
		            			}		            			
		            		}
		            		for(int i=0; i<statusArray.length; i++){
		            			if(statusArray[i].equals(each.getStatus())){
		            				comboBoxStatus.setSelectedIndex(i);
		            			}
		            		}		            		
		            			int i = tabbedPane.getSelectedIndex();
		            			comboBoxDay.setSelectedIndex(i);	            			
		            	}//end if
		            }//end for		            
		          }
		        }
		      }
		    };
		
		list.addMouseListener(mouseListener);		
		return jsp;
		
	}
	
	//---------------------------------------------------create day 
	String[] getDayArray(){		
		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("MMM dd, EEE");
		String[] days = new String[10];
		//days[0]= "Today";
		//days[1]= "Tomorrow";
		//cal.add(Calendar.DATE, 2);
		for(int i=0;i<10;i++){			
			days[i] = dateFormat.format(cal.getTime());
			cal.add(Calendar.DATE, 1);
		}			
		return days;
	}
	
	//-----------------------------------------------------createlist
//	JList<String> createList(){
//		listModel = new DefaultListModel<String>();
//		for(Appointment each: appointmentList){			
//			listModel.addElement(each.toString());
//		}
//	    //Create the list and put it in a scroll pane.
//	    JList<String> list = new JList<String>(listModel);	  //
//	    list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//	    list.setSelectedIndex(0);
//	    list.setBounds(100, 100, 200, -100);
//	    list.setVisible(true);
//	    //list.addListSelectionListener(this);
//	    return list;
//	}//end createList	
	
	void resetAllField(){
		appointmentID = " ";
		textFieldName.setText("");
		textFieldMobile.setText("");
		textArea.setText("");
		comboBoxDay.setSelectedIndex(0);
		comboBoxTime.setSelectedIndex(0);
		comboBoxStatus.setSelectedIndex(0);
	}//end reset
	
}//end class