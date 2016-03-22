package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import common.Module;
import common.ModulePlan;

public class PlanPanel extends JPanel {
	private ArrayList<ModulePanel> modules;
	private JButton regenerateButton;
	private JButton proceedButton;
	private JButton confirmButton;

	public PlanPanel(ModulePlan plan) {
		setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		setAlignmentX(Component.LEFT_ALIGNMENT);
		setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		setBackground(Color.WHITE);
		
		modules = new ArrayList<ModulePanel>();
				
		addPlan(plan);
		
		regenerateButton = new JButton(new AbstractAction("Regenerate") {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO user not satisfied-> regenerate a plan
			}
		});
		proceedButton = new JButton(new AbstractAction("Proceed") {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				makeEditable();
			}
		});
		
		add(regenerateButton);
		add(proceedButton);
	}
	
	public void addPlan(ModulePlan plan) {
		ArrayList<ArrayList<Module>> semesters = plan.getModulePlan();
		for (int i=0; i<semesters.size(); i++) {
			JLabel semester = new JLabel("Semester " + Integer.toString(i+1));
			add(semester);
			ArrayList<Module> modules = semesters.get(i);
			for (int j=0; j<modules.size(); j++) {
				ModulePanel module = new ModulePanel(modules.get(j));
				add(module);
				this.modules.add(module);
			}
		}
		
	}
	
	public void makeEditable() {
		for (ModulePanel module : modules) {
			module.setEditable();
		}
	}

}