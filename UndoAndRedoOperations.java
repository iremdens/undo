/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**İREM ŞİMŞEK 02220224560
 *
 * @author irem
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.undo.*;
import javax.swing.text.*;
import javax.swing.event.*;

public class UndoAndRedoOperations extends JFrame {

    JButton b1, b2, b3;
    JTextArea area;
    JScrollPane pane;
    JPanel p;
    UndoManager manager = new UndoManager();
    JTextArea textArea = new JTextArea();
    
    private void setupUndoHotkeys() {
        String UNDO = "Undo action key";
        String REDO = "Redo action key";
        Action undoAction = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                undo();
            }

            private void undo() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        };
        Action redoAction = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                redo();
            }

            private void redo() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        };

       

        InputMap[] inputMaps = new InputMap[]{
            getInputMap(JComponent.WHEN_FOCUSED),
            getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT),
            getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW),};
        for (InputMap i : inputMaps) {
            i.put(KeyStroke.getKeyStroke("control Z"), UNDO);
            i.put(KeyStroke.getKeyStroke("control Y"), REDO);
        }
    }

    public UndoAndRedoOperations() {
        p = new JPanel();
        area = new JTextArea(5, 30);
        pane = new JScrollPane(area);
        manager = new UndoManager();
        b1 = new JButton("Undo");
        b2 = new JButton("Redo");
        b3 = new JButton("Exit");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    manager.undo();
                } catch (Exception ex) {
                }
            }
        });
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    manager.redo();
                } catch (Exception ex) {
                }
            }
        });
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        area.getDocument().addUndoableEditListener(new UndoableEditListener() {
            public void undoableEditHappened(UndoableEditEvent e) {
                manager.addEdit(e.getEdit());
            }
        });
        p.add(pane);
        p.add(b1);
        p.add(b2);
        p.add(b3);
        add(p);
        setVisible(true);
        pack();
    }

    public static void main(String[] args) {
        UndoAndRedoOperations op = new UndoAndRedoOperations();
    }

    private InputMap getInputMap(int WHEN_FOCUSED) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private Object getActionMap() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
