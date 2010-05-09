package blue;

///*
// * blue - object composition environment for csound
// * Copyright (c) 2000-2005 Steven Yi (stevenyi@gmail.com)
// *
// * This program is free software; you can redistribute it and/or modify
// * it under the terms of the GNU General Public License as published
// * by  the Free Software Foundation; either version 2 of the License or
// * (at your option) any later version.
// *
// * This program is distributed in the hope that it will be useful, but
// * WITHOUT ANY WARRANTY; without even the implied warranty of
// * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// * GNU General Public License for more details.
// *
// * You should have received a copy of the GNU General Public License
// * along with this program; see the file COPYING.LIB.  If not, write to
// * the Free Software Foundation Inc., 59 Temple Place - Suite 330,
// * Boston, MA  02111-1307 USA
// */
//package blue;
//
//import java.awt.BorderLayout;
//import java.awt.Dimension;
//import java.awt.Insets;
//import java.awt.Point;
//import java.awt.datatransfer.Transferable;
//import java.awt.dnd.DnDConstants;
//import java.awt.dnd.DragGestureEvent;
//import java.awt.dnd.DragGestureListener;
//import java.awt.dnd.DragGestureRecognizer;
//import java.awt.dnd.DragSource;
//import java.awt.dnd.DragSourceAdapter;
//import java.awt.dnd.DragSourceDropEvent;
//import java.awt.dnd.DropTarget;
//import java.awt.dnd.DropTargetAdapter;
//import java.awt.dnd.DropTargetDragEvent;
//import java.awt.dnd.DropTargetDropEvent;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.text.MessageFormat;
//
//import javax.swing.AbstractAction;
//import javax.swing.Action;
//import javax.swing.BorderFactory;
//import javax.swing.JButton;
//import javax.swing.JComponent;
//import javax.swing.JFileChooser;
//import javax.swing.JLabel;
//import javax.swing.JMenuItem;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JPopupMenu;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import javax.swing.ListSelectionModel;
//import javax.swing.SwingUtilities;
//import javax.swing.border.BevelBorder;
//import javax.swing.border.EmptyBorder;
//import javax.swing.event.ListSelectionListener;
//import javax.swing.event.PopupMenuEvent;
//import javax.swing.event.PopupMenuListener;
//import javax.swing.filechooser.FileFilter;
//import javax.swing.table.TableColumnModel;
//import javax.swing.table.TableModel;
//import javax.swing.undo.AbstractUndoableEdit;
//import javax.swing.undo.CannotRedoException;
//import javax.swing.undo.CannotUndoException;
//
//import blue.gui.DragManager;
//import blue.gui.FileChooserManager;
//import blue.orchestra.BlueSynthBuilder;
//import blue.orchestra.GenericInstrument;
//import blue.orchestra.Instrument;
//import blue.undo.BlueUndoManager;
//import blue.utility.GenericFileFilter;
//import blue.utility.ObjectUtilities;
//import electric.xml.Document;
//import electric.xml.Element;
//
///**
// * @author steven
// * @author Michael Bechard
// *
// * To change the template for this generated type comment go to Window -
// * Preferences - Java - Code Generation - Code and Comments
// */
//public class ArrangementEditPanel extends JComponent {
//
//    private static final String IMPORT_DIALOG = "instr.import";
//
//    private static final String EXPORT_DIALOG = "instr.export";
//
//    private static MessageFormat toolTipFormat = new MessageFormat(
//            "<html><b>Instrument Type:</b> {0}</html>");
//
//    private final AddInstrumentPopup popup = new AddInstrumentPopup();
//
//    private final InstrumentTablePopup convertPopup = new InstrumentTablePopup();
//
//    JTable arrangementTable;
//
//    Arrangement arrangement = null;
//
//    public ArrangementEditPanel() {
//
//        Insets smallButtonInsets = new Insets(0, 3, 0, 3);
//
//        JPanel topPanel = new JPanel(new BorderLayout());
//        topPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory
//                .createBevelBorder(BevelBorder.RAISED), new EmptyBorder(3, 3,
//                        3, 3)));
//
//
//        JLabel label = new JLabel("Orchestra");
//
//        final JButton addButton = new JButton("+");
//        addButton.setMargin(smallButtonInsets);
//        addButton.setToolTipText(BlueSystem.getString("arrangement.add"));
//        addButton.addActionListener(new ActionListener() {
//
//            public void actionPerformed(ActionEvent e) {
//                int x = addButton.getWidth();
//                int y = 0;
//
//                popup.show(addButton, x, y);
//            }
//
//        });
//
//        topPanel.add(label, BorderLayout.CENTER);
//        topPanel.add(addButton, BorderLayout.EAST);
//
//        arrangementTable = new JTable() {
//
//            public boolean getScrollableTracksViewportHeight() {
//                return getPreferredSize().height < getParent().getHeight();
//            }
//
//            public String getToolTipText(MouseEvent e) {
//                String tip = null;
//                java.awt.Point p = e.getPoint();
//                int rowIndex = rowAtPoint(p);
//
//                if (rowIndex < 0) {
//                    return null;
//                }
//
//                TableModel model = getModel();
//                if (rowIndex < model.getRowCount()) {
//                    Instrument instr = arrangement.getInstrument(rowIndex);
//
//                    Object[] args = { ObjectUtilities.getShortClassName(instr) };
//
//                    tip = toolTipFormat.format(args);
//                }
//
//                return tip;
//            }
//        };
//
//        arrangementTable.addMouseListener(new MouseAdapter() {
//
//            public void mouseClicked(MouseEvent e) {
//                if (arrangementTable.isEditing()) {
//                    return;
//                }
//
//                int rowIndex = arrangementTable.getSelectedRow();
//
//                if (rowIndex < 0) {
//                    return;
//                }
//
//                if (SwingUtilities.isRightMouseButton(e)) {
//                    convertPopup.show(arrangementTable, e.getX(), e.getY());
//                }
//
//            }
//        });
//        // arrangementTable.setModel(arrangement);
//
//        arrangementTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//
//        JScrollPane tableScrollPane = new JScrollPane(arrangementTable);
//        tableScrollPane.setBorder(null);
//
//        this.setLayout(new BorderLayout());
//        this.add(topPanel, BorderLayout.NORTH);
//        this.add(tableScrollPane, BorderLayout.CENTER);
//
//        new ArrangementDragSource(arrangementTable, DnDConstants.ACTION_COPY);
//        // new DropTarget(arrangementTable, new TableHilightDropListener());
//
//        new ArrangementTableDropTarget(arrangementTable);
//
//        // arrangementTable.addMouseListener(new MouseAdapter() {
//        // public void mouseClicked(MouseEvent e) {
//        // if (SwingUtilities.isRightMouseButton(e)) {
//        // System.out.println("testing");
//        // } else {
//        // int row = arrangementTable.getSelectedRow();
//        // if (row >= 0) {
//        // instrGUI.editInstrument(tableModel.getInstrument(row));
//        // }
//        // }
//        // }
//        // });
//
//        /* setup file choosers */
//
//        File defaultFile = new File(ProgramOptions.getGeneralSettings()
//                .getDefaultDirectory()
//                + File.separator + "default.binstr");
//
//        FileFilter presetFilter = new GenericFileFilter("binstr",
//                "blue Instrument File");
//
//        FileChooserManager.addFilter(IMPORT_DIALOG, presetFilter);
//        FileChooserManager.setDialogTitle(IMPORT_DIALOG, "Import Instrument");
//        FileChooserManager.setSelectedFile(IMPORT_DIALOG, defaultFile);
//
//        FileChooserManager.addFilter(EXPORT_DIALOG, presetFilter);
//        FileChooserManager.setDialogTitle(EXPORT_DIALOG, "Export Instrument");
//        FileChooserManager.setSelectedFile(EXPORT_DIALOG, defaultFile);
//
//    }
//
//    public void addListSelectionListener(ListSelectionListener listener) {
//        arrangementTable.getSelectionModel().addListSelectionListener(listener);
//    }
//
//    public Instrument getSelectedInstrument() {
//        if (arrangement == null) {
//            return null;
//        }
//
//        int row = arrangementTable.getSelectedRow();
//
//        if (row >= 0) {
//            return arrangement.getInstrument(row);
//        }
//
//        return null;
//    }
//
//    private void setupTableProperties() {
//        final TableColumnModel model = arrangementTable.getTableHeader()
//                .getColumnModel();
//        model.getColumn(0).setPreferredWidth(25);
//        model.getColumn(0).setMaxWidth(25);
//        model.getColumn(0).setMinWidth(25);
//        model.getColumn(1).setPreferredWidth(60);
//        model.getColumn(1).setResizable(true);
//        model.getColumn(2).setPreferredWidth(180);
//
//        arrangementTable.getTableHeader().setReorderingAllowed(false);
//        arrangementTable.getTableHeader().setPreferredSize(
//                new Dimension(17, 21));
//    }
//
//    private void addInstrument(Instrument instr) {
//        int selectedRow = arrangementTable.getSelectedRow();
//        addInstrument(instr, selectedRow);
//    }
//
//    private void addInstrument(Instrument instr, int selectedRow) {
//
//        if (selectedRow < 0) {
//            arrangement.addInstrument(null, instr);
//        } else {
//            String instrumentId = (String) arrangement.getValueAt(selectedRow,
//                    1);
//            arrangement.addInstrument(instrumentId, instr);
//        }
//
//        String instrId = arrangement.getInstrumentId(instr);
//
//        if (instrId != null) {
//            OrchestraEdit edit = new OrchestraEdit(arrangement, instr, instrId,
//                    OrchestraEdit.ADD);
//            BlueUndoManager.setUndoManager("orchestra");
//            BlueUndoManager.addEdit(edit);
//        }
//    }
//
//    public void convertToBSB() {
//        int selectedRow = arrangementTable.getSelectedRow();
//        if (selectedRow < 0) {
//            return;
//        }
//
//        String instrumentId = (String) arrangement.getValueAt(selectedRow, 1);
//
//        Instrument instr = arrangement.getInstrument(selectedRow);
//
//        if (instr instanceof GenericInstrument) {
//            GenericInstrument genInstr = (GenericInstrument) instr;
//
//            BlueSynthBuilder bsb = new BlueSynthBuilder();
//
//            bsb.setName(genInstr.getName());
//            bsb.setComment(genInstr.getComment());
//            bsb.setGlobalOrc(genInstr.getGlobalOrc());
//            bsb.setGlobalSco(genInstr.getGlobalSco());
//            bsb.setInstrumentText(genInstr.getText());
//            bsb.setOpcodeList(genInstr.getOpcodeList());
//
//            arrangement.replaceInstrument(instrumentId, bsb);
//        }
//
//    }
//
//    public void removeInstrument() {
//        int selectedRow = arrangementTable.getSelectedRow();
//        if (selectedRow < 0) {
//            return;
//        }
//
//        Instrument instr = arrangement.removeInstrument(selectedRow);
//
//        String instrId = arrangement.getInstrumentId(instr);
//
//        if (instrId != null) {
//            OrchestraEdit edit = new OrchestraEdit(arrangement, instr, instrId,
//                    OrchestraEdit.REMOVE);
//            BlueUndoManager.setUndoManager("orchestra");
//            BlueUndoManager.addEdit(edit);
//        }
//    }
//
//    public void cutInstrument() {
//        copyInstrument();
//        removeInstrument();
//    }
//
//    public void copyInstrument() {
//        int selectedRow = arrangementTable.getSelectedRow();
//        if (selectedRow < 0) {
//            return;
//        }
//
//        Instrument instr = arrangement.getInstrument(selectedRow);
//
//        Object clone = instr.clone();
//
//        CopyBuffer.setBufferedObject(CopyBuffer.INSTRUMENT, clone);
//    }
//
//    public void pasteInstrument() {
//        Object obj = CopyBuffer.getBufferedObject(CopyBuffer.INSTRUMENT);
//
//        if (obj == null || !(obj instanceof Instrument)) {
//            return;
//        }
//
//        Instrument instr = (Instrument) obj;
//
//        Instrument clone = (Instrument) instr.clone();
//
//        if (clone instanceof BlueSynthBuilder) {
//            ((BlueSynthBuilder) clone).clearParameters();
//        }
//
//        addInstrument(clone);
//    }
//
//    // public void instrumentRemoved(Instrument instr) {
//    // tableModel.instrumentRemoved(instr);
//    // }
//
//    public void setArrangement(Arrangement arrangement) {
//        if (arrangementTable.isEditing()) {
//            arrangementTable.getCellEditor().cancelCellEditing();
//        }
//
//        this.arrangement = arrangement;
//        arrangementTable.setModel(arrangement);
//
//        setupTableProperties();
//    }
//
//    static class ArrangementDragSource extends DragSourceAdapter implements
//            DragGestureListener {
//
//        DragSource source;
//
//        DragGestureRecognizer recognizer;
//
//        JTable table;
//
//        TransferableInstrument transferable;
//
//        // Object oldNode;
//
//        public ArrangementDragSource(JTable table, int actions) {
//            this.table = table;
//            source = new DragSource();
//            recognizer = source.createDefaultDragGestureRecognizer(table,
//                    actions, this);
//        }
//
//        public void dragGestureRecognized(DragGestureEvent dge) {
//            int index = table.getSelectedRow();
//            if (index < 0) {
//                return;
//            }
//
//            Arrangement arr = (Arrangement) table.getModel();
//
//            Instrument instr = arr.getInstrument(index);
//
//            // USE CLONE OF OBJ AS TRANSFERRABLE ISN'T MAKING CLONE (WHY?)
//            Object cloneNode = instr.clone();
//
//            transferable = new TransferableInstrument(cloneNode);
//            source.startDrag(dge, null, transferable, this);
//            DragManager.setDragSource(table);
//        }
//
//        public void dragDropEnd(DragSourceDropEvent dsde) {
//            if (dsde.getDropSuccess()) {
//
//                // System.out.println("DragSource: " + oldNode.hashCode());
//
//                // if (oldNode instanceof Instrument) {
//                //
//                // ((InstrumentLibrary) sourceTree.getModel())
//                // .removeInstrument((Instrument) oldNode);
//                //
//                // } else if (oldNode instanceof InstrumentCategory) {
//                //
//                // ((InstrumentLibrary) sourceTree.getModel())
//                // .removeCategory((InstrumentCategory) oldNode);
//                //
//                // }
//            }
//
//        }
//
//    }
//
//    class ArrangementTableDropTarget extends DropTargetAdapter {
//        DropTarget target;
//
//        JTable targetTable;
//
//        public ArrangementTableDropTarget(JTable table) {
//            targetTable = table;
//            target = new DropTarget(targetTable, this);
//        }
//
//        public void dragEnter(DropTargetDragEvent dtde) {
//
//            if (!dtde
//                    .isDataFlavorSupported(TransferableInstrument.INSTR_FLAVOR)) {
//                dtde.rejectDrag();
//                return;
//            }
//
//            if (DragManager.getDragSource() != targetTable) {
//                dtde.acceptDrag(dtde.getDropAction());
//
//            } else {
//                dtde.rejectDrag();
//            }
//
//        }
//
//        public void dragOver(DropTargetDragEvent dtde) {
//            dragEnter(dtde);
//        }
//
//        public void drop(DropTargetDropEvent dtde) {
//            Point pt = dtde.getLocation();
//
//            if (!dtde
//                    .isDataFlavorSupported(TransferableInstrument.INSTR_FLAVOR)
//                    || ((dtde.getSourceActions() & DnDConstants.ACTION_COPY) != DnDConstants.ACTION_COPY)) {
//                dtde.rejectDrop();
//                return;
//            }
//
//            try {
//                Transferable tr = dtde.getTransferable();
//
//                Object transferNode = tr
//                        .getTransferData(TransferableInstrument.INSTR_FLAVOR);
//
//                Instrument instrument = (Instrument) transferNode;
//
//                int h = targetTable.getRowHeight();
//
//                int listIndex = pt != null ? (pt.y / h) : -1;
//
//                if (listIndex < 0) {
//                    dtde.rejectDrop();
//                    return;
//                }
//
//                if (listIndex >= targetTable.getRowCount()) {
//                    listIndex = targetTable.getRowCount() - 1;
//                }
//
//                dtde.acceptDrop(DnDConstants.ACTION_COPY);
//
//                if (instrument instanceof BlueSynthBuilder) {
//                    ((BlueSynthBuilder) instrument).clearParameters();
//                }
//
//                addInstrument(instrument, listIndex);
//
//                dtde.dropComplete(true);
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    class InstrumentTablePopup extends JPopupMenu {
//
//        JMenuItem removeInstrumentMenuItem = new JMenuItem(BlueSystem
//                .getString("instrument.remove"));
//
//        JMenuItem cutMenuItem = new JMenuItem(BlueSystem
//                .getString("instrument.cut"));
//
//        JMenuItem copyMenuItem = new JMenuItem(BlueSystem
//                .getString("instrument.copy"));
//
//        JMenuItem pasteMenuItem = new JMenuItem(BlueSystem
//                .getString("instrument.paste"));
//
//        JMenuItem convertToBSB = new JMenuItem();
//
//        Action exportItem;
//
//        public InstrumentTablePopup() {
//            removeInstrumentMenuItem.addActionListener(new ActionListener() {
//
//                public void actionPerformed(ActionEvent e) {
//                    removeInstrument();
//                }
//            });
//            cutMenuItem.addActionListener(new ActionListener() {
//
//                public void actionPerformed(ActionEvent e) {
//                    cutInstrument();
//                }
//            });
//            copyMenuItem.addActionListener(new ActionListener() {
//
//                public void actionPerformed(ActionEvent e) {
//                    copyInstrument();
//                }
//            });
//            pasteMenuItem.addActionListener(new ActionListener() {
//
//                public void actionPerformed(ActionEvent e) {
//                    pasteInstrument();
//                }
//            });
//
//            convertToBSB.setText("Convert to BlueSynthBuilder");
//            convertToBSB.addActionListener(new ActionListener() {
//
//                public void actionPerformed(ActionEvent e) {
//                    convertToBSB();
//                }
//
//            });
//
//            Action importItem = new AbstractAction(BlueSystem
//                    .getString("common.import")) {
//
//                public void actionPerformed(ActionEvent e) {
//
//                    int retVal = FileChooserManager.showOpenDialog(
//                            IMPORT_DIALOG,
//                            SwingUtilities.getRoot(SwingUtilities
//                                    .getRoot(ArrangementEditPanel.this)));
//
//                    if (retVal == JFileChooser.APPROVE_OPTION) {
//
//                        File f = FileChooserManager
//                                .getSelectedFile(IMPORT_DIALOG);
//                        Document doc;
//
//                        try {
//                            doc = new Document(f);
//                            Element root = doc.getRoot();
//                            if (root.getName().equals("instrument")) {
//                                Instrument tempInstr = (Instrument) ObjectUtilities
//                                        .loadFromXML(root);
//                                addInstrument(tempInstr);
//                            } else {
//                                JOptionPane
//                                        .showMessageDialog(
//                                                SwingUtilities
//                                                        .getRoot(ArrangementEditPanel.this),
//                                                "Error: File did not contain instrument",
//                                                "Error",
//                                                JOptionPane.ERROR_MESSAGE);
//                            }
//
//                        } catch (Exception ex) {
//                            ex.printStackTrace();
//                            JOptionPane
//                                    .showMessageDialog(
//                                            SwingUtilities
//                                                    .getRoot(ArrangementEditPanel.this),
//                                            "Error: Could not read instrument from file",
//                                            "Error", JOptionPane.ERROR_MESSAGE);
//                        }
//
//                    }
//
//                }
//
//            };
//
//            exportItem = new AbstractAction(BlueSystem
//                    .getString("common.export")) {
//
//                public void actionPerformed(ActionEvent e) {
//                    int selectedRow = arrangementTable.getSelectedRow();
//                    if (selectedRow < 0) {
//                        return;
//                    }
//
//                    Instrument instr = arrangement.getInstrument(selectedRow);
//
//                    int retVal = FileChooserManager.showSaveDialog(
//                            EXPORT_DIALOG, SwingUtilities
//                                    .getRoot(ArrangementEditPanel.this));
//
//                    if (retVal == JFileChooser.APPROVE_OPTION) {
//
//                        File f = FileChooserManager
//                                .getSelectedFile(EXPORT_DIALOG);
//
//                        if (f.exists()) {
//                            int overWrite = JOptionPane
//                                    .showConfirmDialog(
//                                            SwingUtilities
//                                                    .getRoot(ArrangementEditPanel.this),
//                                            "Please confirm you would like to overwrite this file.");
//
//                            if (overWrite != JOptionPane.OK_OPTION) {
//                                return;
//                            }
//                        }
//
//                        Element node = instr.saveAsXML();
//
//                        PrintWriter out;
//
//                        try {
//                            out = new PrintWriter(new FileWriter(f));
//                            out.print(node.toString());
//
//                            out.flush();
//                            out.close();
//                        } catch (IOException ex) {
//                            ex.printStackTrace();
//                        }
//
//                    }
//                }
//
//            };
//
//            this.add(removeInstrumentMenuItem);
//            this.addSeparator();
//            this.add(cutMenuItem);
//            this.add(copyMenuItem);
//            this.add(pasteMenuItem);
//            this.addSeparator();
//            this.add(convertToBSB);
//            this.addSeparator();
//            this.add(importItem);
//            this.add(exportItem);
//
//            setupPopupListener();
//        }
//
//        private void setupPopupListener() {
//            this.addPopupMenuListener(new PopupMenuListener() {
//
//                public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
//                    int rowIndex = arrangementTable.getSelectedRow();
//
//                    boolean selected = (rowIndex >= 0);
//
//                    cutMenuItem.setEnabled(selected);
//                    copyMenuItem.setEnabled(selected);
//                    removeInstrumentMenuItem.setEnabled(selected);
//                    exportItem.setEnabled(selected);
//
//                    if (selected) {
//                        Instrument instr = arrangement.getInstrument(rowIndex);
//                        convertToBSB
//                                .setEnabled(instr instanceof GenericInstrument);
//                    } else {
//                        convertToBSB.setEnabled(false);
//                    }
//
//                    boolean bufferFull = !(CopyBuffer
//                            .getBufferedObject(CopyBuffer.INSTRUMENT) == null);
//                    pasteMenuItem.setEnabled(bufferFull);
//                }
//
//                public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
//                }
//
//                public void popupMenuCanceled(PopupMenuEvent e) {
//                }
//
//            });
//
//        }
//
//    }
//
//    class AddInstrumentPopup extends JPopupMenu {
//
//        public AddInstrumentPopup() {
//            Class[] instruments = BlueSystem.getInstrumentClasses();
//            String className;
//            JMenuItem temp;
//
//            this.setLabel(BlueSystem.getString("instrument.addInstrument"));
//
//            for (int i = 0; i < instruments.length; i++) {
//                className = instruments[i].getName();
//
//                try {
//                    // final Instrument tempInst = (Instrument) instruments[i]
//                    // .newInstance();
//                    temp = new JMenuItem();
//
//                    temp.setText(BlueSystem.getShortClassName(className));
//                    temp.setActionCommand(className);
//                    temp.addActionListener(new ActionListener() {
//
//                        public void actionPerformed(ActionEvent e) {
//                            fireAddInstrument(e.getActionCommand());
//                        }
//                    });
//                    this.add(temp);
//
//                } catch (Exception e) {
//                    System.err
//                            .println("["
//                                    + BlueSystem.getString("message.error")
//                                    + "] "
//                                    + BlueSystem
//                                            .getString("orchestraGUI.error.instrumentLoading")
//                                    + " " + className);
//                }
//
//            }
//
//            pack();
//
//        }
//
//        private void fireAddInstrument(String className) {
//            try {
//                Class c = BlueSystem.getClassLoader().loadClass(className);
//                Instrument newInstrument = (Instrument) c.newInstance();
//                addInstrument(newInstrument);
//            } catch (ClassNotFoundException e) {
//                JOptionPane.showMessageDialog(null,
//                        "Error loading Instrument: " + className);
//                e.printStackTrace();
//            } catch (InstantiationException e) {
//                JOptionPane.showMessageDialog(null,
//                        "Error loading Instrument: " + className);
//                e.printStackTrace();
//            } catch (IllegalAccessException e) {
//                JOptionPane.showMessageDialog(null,
//                        "Error loading Instrument: " + className);
//                e.printStackTrace();
//            }
//
//        }
//
//    }
//
//    public void deselect() {
//        arrangementTable.clearSelection();
//    }
//
//    static class OrchestraEdit extends AbstractUndoableEdit {
//        public static final int ADD = 0;
//
//        public static final int REMOVE = 1;
//
//        private final Arrangement arrangement;
//
//        private final int type;
//
//        private final Instrument instr;
//
//        private final String instrId;
//
//        public OrchestraEdit(Arrangement arrangement, Instrument instr,
//                String instrId, int type) {
//
//            this.arrangement = arrangement;
//            this.instr = instr;
//            this.instrId = instrId;
//            this.type = type;
//        }
//
//        public void redo() throws CannotRedoException {
//            super.redo();
//
//            if (this.type == ADD) {
//                arrangement.addInstrumentWithId(instr, instrId);
//            } else {
//                arrangement.removeInstrument(instrId);
//            }
//        }
//
//        public void undo() throws CannotUndoException {
//            super.undo();
//
//            if (this.type == ADD) {
//                arrangement.removeInstrument(instrId);
//            } else {
//                arrangement.addInstrumentWithId(instr, instrId);
//            }
//        }
//
//        public String getPresentationName() {
//            if (this.type == ADD) {
//                return "Add Instrument";
//            }
//            return "Remove Instrument";
//        }
//    }
//}