//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package de.htwk_leipzig.imn.visualg.model.algorithm;

import de.htwk_leipzig.imn.visualg.application.ActiveAlgorithm;
import de.htwk_leipzig.imn.visualg.model.structure.AVLTreeStructure;
import de.htwk_leipzig.imn.visualg.model.structure.Node;
import java.util.Arrays;

public class AVLTreeInsert<T extends Comparable> extends RecursiveAlgorithm<AVLTreeStructure<T>, Node<T>> {
    private T msInsertValue;
    private static boolean msJUnitTestCase;
    private static boolean msKeyIncluded;
    private Node mtempNode;

    public static boolean isKeyIncluded() {
        return msKeyIncluded;
    }

    public static void setKeyIncluded(boolean msKeyIncluded) {
        AVLTreeInsert.msKeyIncluded = msKeyIncluded;
    }

    public AVLTreeInsert(AVLTreeStructure<T> structure, T insertValue) {
        super(structure);
        this.msInsertValue = insertValue;
        this.addPseudocode(this.msInsertValue);
    }

    public AVLTreeInsert(AVLTreeStructure<T> structure, T searchedKey, boolean jUnitTestCase) {
        super(structure);
        this.msInsertValue = searchedKey;
        msJUnitTestCase = true;
        this.addPseudocode(this.msInsertValue);
    }

    protected void execute() {
        Node temp = ((AVLTreeStructure)this.mStructure).getRootNode();
        ((AVLTreeStructure)this.mStructure).highlightNode(((AVLTreeStructure)this.mStructure).getNodesList(), AlgorithmOperationType.DEFAULT);
        this.ifAlgoRunReturn(-1);
        if (this.checkBreakpoint(0)) {
            ((AVLTreeStructure)this.mStructure).highlightNode(temp, AlgorithmOperationType.READ);
            this.ifAlgoRunReturn(0);
        }

        while(temp != null && this.msInsertValue != temp.getValue()) {
            if (this.checkBreakpoint(1)) {
                this.ifAlgoRunReturn(1);
            }

            if (this.msInsertValue.compareTo(temp.getValue()) < 0) {
                ((AVLTreeStructure)this.mStructure).highlightNode(temp, AlgorithmOperationType.INACTIVE);
                this.runLeft(temp);
                temp = this.mtempNode;
            } else {
                ((AVLTreeStructure)this.mStructure).highlightNode(temp, AlgorithmOperationType.INACTIVE);
                this.runRight(temp);
                temp = this.mtempNode;
            }
        }

        if (this.checkBreakpoint(1)) {
            this.ifAlgoRunReturn(1);
        }

        if (temp == null) {
            this.incrCounter(0);
            if (this.checkBreakpoint(2)) {
                this.ifAlgoRunReturn(2);
            }

            if (this.checkBreakpoint(3)) {
                ((AVLTreeStructure)this.mStructure).insertNodeWithoutRebalance(this.msInsertValue);
                this.ifAlgoRunReturn(3);
            }

            if (!msJUnitTestCase) {
                ((AVLTreeStructure)this.mStructure).reDraw();
            }

            ((AVLTreeStructure)this.mStructure).highlightNode(((AVLTreeStructure)this.mStructure).getNode(this.msInsertValue), AlgorithmOperationType.WRITE);
            if (!msJUnitTestCase) {
                this.insertSuccessfulMessage();
                this.startRebalanceAlgo();
                return;
            }

            msKeyIncluded = true;
        } else {
            this.incrCounter(1);
            if (this.checkBreakpoint(4)) {
                ((AVLTreeStructure)this.mStructure).highlightNode(temp, AlgorithmOperationType.FOUND);
                this.ifAlgoRunReturn(4);
            }

            if (this.checkBreakpoint(5)) {
                if (!msJUnitTestCase) {
                    this.insertUnuccessfulMessage();
                } else {
                    msKeyIncluded = false;
                }

                this.ifAlgoRunReturn(5);
            }
        }

        if (!msJUnitTestCase) {
            this.timerForUnhighlightAll();
            ActiveAlgorithm.stop();
        }

    }

    private void addPseudocode(T insertValue) {
        this.mPseudocode.setShowComparisons(false);
        this.addCounters(4);
        this.mPseudocode.addCounters(Arrays.asList(new PseudoCodeCounter(0, 4), new PseudoCodeCounter(1, 6), new PseudoCodeCounter(2, 8), new PseudoCodeCounter(3, 11)));
        this.mName = "Einfügen-AVL-R";
        this.mParameters = this.mParameters + "Schlüssel neuerWert(" + insertValue.toString() + ")";
        this.mPseudocode.addLine("Rückgabewert: neue Wurzel, Info ob Baumhöhe gleich; Seiteneffekt");
        this.mPseudocode.addLine("el → anker", 0);
        this.mPseudocode.addLine("switch", 1);
        this.mPseudocode.addLine("case el = NULL:", 2);
        this.mPseudocode.addLine("    return allokiere Element(neuerWert)", 3);
        this.mPseudocode.addLine("case neuerWert = el.wert:", 4);
        this.mPseudocode.addLine("    error \"Element schon enthalten\"", 5);
        this.mPseudocode.addLine("case neuerWert < el.wert:", 6);
        this.mPseudocode.addLine("    el.links→EINFÜGEN-BAUM(neuerWert,neueDaten,el.links)", 7);
        this.mPseudocode.addLine("    return el", 8);
        this.mPseudocode.addLine("case neuerWert > el.wert:", 9);
        this.mPseudocode.addLine("    el.rechts→EINFÜGEN-BAUM(neuerWert,neueDaten,el.rechts)", 10);
        this.mPseudocode.addLine("    return el", 11);
    }

    private void runLeft(Node temp) {
        this.push(temp, 6);
        this.mtempNode = temp;
        this.incrCounter(2);
        if (this.checkBreakpoint(6)) {
            this.ifAlgoRunReturn(6);
        }

        if (this.checkBreakpoint(7)) {
            if (this.mtempNode.getLeftChild() != null) {
                ((AVLTreeStructure)this.mStructure).highlightNode(this.mtempNode.getLeftChild(), AlgorithmOperationType.READ);
            }

            this.mtempNode = this.mtempNode.getLeftChild();
            this.ifAlgoRunReturn(7);
        }

        if (this.checkBreakpoint(8)) {
            this.ifAlgoRunReturn(8);
        }

    }

    private void runRight(Node temp) {
        this.push(temp, 9);
        this.mtempNode = temp;
        this.incrCounter(3);
        if (this.checkBreakpoint(9)) {
            this.ifAlgoRunReturn(9);
        }

        if (this.checkBreakpoint(10)) {
            if (this.mtempNode.getRightChild() != null) {
                ((AVLTreeStructure)this.mStructure).highlightNode(this.mtempNode.getRightChild(), AlgorithmOperationType.READ);
            }

            this.mtempNode = this.mtempNode.getRightChild();
            this.ifAlgoRunReturn(10);
        }

        if (this.checkBreakpoint(11)) {
            this.ifAlgoRunReturn(11);
        }

    }

    private void startRebalanceAlgo() {
        T rebalanceValue = ((AVLTreeStructure)this.mStructure).getNode(this.msInsertValue).getParent().getValue();
        ActiveAlgorithm.pause();

        try {
            ActiveAlgorithm.multiRun(new AVLTreeRebalance((AVLTreeStructure)this.mStructure, rebalanceValue));
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }

    private void timerForUnhighlightAll() {
        try {
            Thread.sleep(4000L);
        } catch (InterruptedException var2) {
        }

        ((AVLTreeStructure)this.mStructure).highlightNode(((AVLTreeStructure)this.mStructure).getNodesList(), AlgorithmOperationType.DEFAULT);
    }

    private void insertSuccessfulMessage() {
        msKeyIncluded = true;
        String title = "Ergebnis:";
        String insertMessage = "Der Knoten \"" + this.msInsertValue + "\" wurde erfolgreich hinzugefügt. Drücken Sie nun auf Play um die AVL-Bedingung zu prüfen.";
        this.resultDialog(title, insertMessage, "#dcffb8");
    }

    private void insertUnuccessfulMessage() {
        msKeyIncluded = false;
        String title = "Ergebnis:";
        String nodeExistMessage = "Der Knoten \"" + this.msInsertValue + "\" ist im Baum bereits enthalten.";
        this.resultDialog(title, nodeExistMessage, "#FFA5A5");
        ((AVLTreeStructure)this.mStructure).highlightNode(((AVLTreeStructure)this.mStructure).getNodesList(), AlgorithmOperationType.DEFAULT);
    }
}
