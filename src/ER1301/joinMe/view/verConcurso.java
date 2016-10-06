/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ER1301.joinMe.view;

import ER1301.joinMe.model.Sentence;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Andrea
 */
public class verConcurso extends javax.swing.JFrame {

    private void reloadSentencesList() {

        String[] sentences
                = Main.tempContest.getSentencesDetails().toArray(new String[Main.tempContest.getSentencesDetails().size()]);

        resultsContestList.setModel(new javax.swing.AbstractListModel() {
            public int getSize() {
                return sentences.length;
            }

            public Object getElementAt(int i) {
                return sentences[i];
            }
        });

        setLocationRelativeTo(null);
    }

    /**
     * Creates new form verConcurso
     */
    public verConcurso() {
        initComponents();

        jLabel1.setText("Resultados del concurso: " + Main.tempContest.getTitle());

        if (Main.tempContest.getParticipants().contains(Main.logedInUser.getName())) {
            isOnContest.setEnabled(false);
            System.out.println("Is registered");
        } else {
            System.out.println("Is not registered");
        }

        reloadSentencesList();

        ActionListener volver = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                concursoForm.main(null);
                dispose();
            }
        };

        volverButton.addActionListener(volver);

        ActionListener suscribeContest = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.tempContest.addParticipantsToContest(Main.logedInUser.getName());
                isOnContest.setEnabled(false);
                System.out.println("Now registered");

            }
        };

        isOnContest.addActionListener(suscribeContest);

        ActionListener rateSentenceSelected = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int rating = Integer.valueOf((String) ratingValue.getSelectedItem());
                int oldRating = Main.tempContest.getSentences().get(resultsContestList.getSelectedIndex()).getRating();

                //System.out.println(Main.tempContest.getSentences().get(resultsContestList.getSelectedIndex()));
                Main.tempContest.getSentences().get(resultsContestList.getSelectedIndex()).setRating(oldRating + rating);
                reloadSentencesList();

            }
        };

        rateSentence.addActionListener(rateSentenceSelected);

        ActionListener sendSentenceByMe = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Sentence s = new Sentence(Main.logedInUser.getName(),sentenceTextBox.getText(),Main.tempContest.getTitle());
             
                Main.tempContest.addSentenceToContest(s);
                
                reloadSentencesList();

            }
        };

        sendSentence.addActionListener(sendSentenceByMe);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        resultsContestList = new javax.swing.JList<String>();
        jLabel1 = new javax.swing.JLabel();
        volverButton = new javax.swing.JButton();
        sentenceTextBox = new javax.swing.JTextField();
        sendSentence = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        rateSentence = new javax.swing.JButton();
        ratingValue = new javax.swing.JComboBox<String>();
        jLabel3 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        isOnContest = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        resultsContestList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(resultsContestList);

        jLabel1.setText("Resultados del Concurso");

        volverButton.setText("Volver");

        sentenceTextBox.setText("Inscribir frase*");

        sendSentence.setText("Enviar frase");

        jLabel2.setText("*Límite 5");

        rateSentence.setText("Valorar frase");

        ratingValue.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3" }));

        jLabel3.setText("*Límite 3 (3,2 y 1 punto)");

        jButton4.setText("Retar usuario");

        isOnContest.setText("Darse de alta");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(volverButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(28, 28, 28)
                        .addComponent(isOnContest)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sentenceTextBox)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(sendSentence))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(ratingValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rateSentence)))
                                .addGap(0, 137, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jButton4))
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(isOnContest)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sentenceTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(sendSentence))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ratingValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rateSentence))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(volverButton)
                    .addComponent(jLabel3))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(verConcurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(verConcurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(verConcurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(verConcurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new verConcurso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton isOnContest;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton rateSentence;
    private javax.swing.JComboBox<String> ratingValue;
    private javax.swing.JList<String> resultsContestList;
    private javax.swing.JButton sendSentence;
    private javax.swing.JTextField sentenceTextBox;
    private javax.swing.JButton volverButton;
    // End of variables declaration//GEN-END:variables
}
