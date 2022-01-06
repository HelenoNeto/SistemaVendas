/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitarios;

import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicComboBoxUI;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author Administrador
 */
public class AutoCompleta {

    public static void autocompletaCB(JComboBox jcb, ActionListener acaoDoComboBox, boolean comSeta, boolean editavel, boolean popupVisivel, List lista, String itemSelecionado) {
        jcb.setEditable(editavel);
        jcb.removeAllItems();
        jcb.setPopupVisible(popupVisivel);
        for (int i = 0; i < lista.size(); i++) {
            jcb.addItem(lista.get(i));
        }
        jcb.setSelectedItem(itemSelecionado);
        if (!comSeta) {
            jcb.setUI(new BasicComboBoxUI() {

                @Override
                protected JButton createArrowButton() {
                    return new JButton() {

                        @Override
                        public int getWidth() {
                            return 0;
                        }
                    };
                }
            });
        }
        AutoCompleteDecorator.decorate(jcb); //tem que ser antes do actionPerformed se não o enter não funciona para buscar
        jcb.getEditor().addActionListener(acaoDoComboBox);
    }

    public static void autocompletaTF(JTextField tf, ActionListener acaoTexfFild, boolean editavel, List lista, String texto) {
        tf.setEditable(editavel);
        tf.setText(texto);
        AutoCompleteDecorator.decorate(tf, lista, false);
    }
}
