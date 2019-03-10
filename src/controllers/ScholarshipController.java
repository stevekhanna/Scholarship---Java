package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import displayScholarship.*;
import objects.*;
import myJStuff.MyController;

public class ScholarshipController extends MyController{
	
	private JPanel scholarshipPanel;
	private JPanel scholarshipsPanel;
	
	
	private ScholarshipPanel sp;
	private ScholarshipsPanel ssp;
	
	
	private boolean isAdmin;
	
	public ScholarshipController(ActionListener globalListener,JFrame frame) {
		super(globalListener, frame);
	}
	
	public void start(boolean isAdmin, HashMap<Integer, Scholarship> scMap) {
		this.isAdmin = isAdmin;
		
		sp = new ScholarshipPanel(this);
		ssp = new ScholarshipsPanel(this,globalListener);
		scholarshipPanel = sp.getContentPane();
		scholarshipsPanel = ssp.getContentPane();
		
		scholarshipLoop(scMap);
		switchPanel(scholarshipsPanel);
	}
	
	/**
	 * Loop through the list of scholarships and add them to the screen
	 * @param scMap
	 */
	public void scholarshipLoop(HashMap<Integer, Scholarship> scMap) {
		for(Integer ID: scMap.keySet()) {
			Scholarship value = scMap.get(ID);
			ssp.displayScholarship(value);
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
