/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgMayTinh;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Tom W
 */
public class MayTinh extends javax.swing.JFrame {
    
    double firstNumber;
    double secondNumber;
    double result;
    String operations;
    String answer = null;
    
    
    public MayTinh() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            System.out.println(ex);
        }
        initComponents();
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblMayTinh = new javax.swing.JLabel();
        txtMayTinh = new javax.swing.JTextField();
        btnAC = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btn_0 = new javax.swing.JButton();
        btn_1 = new javax.swing.JButton();
        btn_2 = new javax.swing.JButton();
        btn_3 = new javax.swing.JButton();
        btn_4 = new javax.swing.JButton();
        btn_5 = new javax.swing.JButton();
        btn_6 = new javax.swing.JButton();
        btn_7 = new javax.swing.JButton();
        btn_8 = new javax.swing.JButton();
        btn_9 = new javax.swing.JButton();
        btn_Phay = new javax.swing.JButton();
        btnCong = new javax.swing.JButton();
        btnTru = new javax.swing.JButton();
        btnNhan = new javax.swing.JButton();
        btnChia = new javax.swing.JButton();
        btn_ChiaDu = new javax.swing.JButton();
        btnBang = new javax.swing.JButton();
        txtPhepTinh = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblMayTinh.setFont(new java.awt.Font("DigifaceWide", 1, 30)); // NOI18N
        lblMayTinh.setForeground(new java.awt.Color(0, 102, 102));
        lblMayTinh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMayTinh.setText("MÁY TÍNH");
        lblMayTinh.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 204)));

        txtMayTinh.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtMayTinh.setForeground(new java.awt.Color(51, 51, 51));
        txtMayTinh.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtMayTinh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMayTinhKeyTyped(evt);
            }
        });

        btnAC.setBackground(new java.awt.Color(255, 51, 102));
        btnAC.setFont(new java.awt.Font("DigifaceWide", 1, 18)); // NOI18N
        btnAC.setForeground(new java.awt.Color(255, 255, 255));
        btnAC.setText("AC");
        btnAC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnACActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(255, 153, 153));
        btnXoa.setFont(new java.awt.Font("DigifaceWide", 1, 18)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setText("<");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btn_0.setBackground(new java.awt.Color(204, 204, 204));
        btn_0.setFont(new java.awt.Font("DigifaceWide", 1, 18)); // NOI18N
        btn_0.setForeground(new java.awt.Color(51, 51, 51));
        btn_0.setText("0");
        btn_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_0ActionPerformed(evt);
            }
        });

        btn_1.setBackground(new java.awt.Color(204, 204, 204));
        btn_1.setFont(new java.awt.Font("DigifaceWide", 1, 18)); // NOI18N
        btn_1.setForeground(new java.awt.Color(51, 51, 51));
        btn_1.setText("1");
        btn_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_1ActionPerformed(evt);
            }
        });

        btn_2.setBackground(new java.awt.Color(204, 204, 204));
        btn_2.setFont(new java.awt.Font("DigifaceWide", 1, 18)); // NOI18N
        btn_2.setForeground(new java.awt.Color(51, 51, 51));
        btn_2.setText("2");
        btn_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_2ActionPerformed(evt);
            }
        });

        btn_3.setBackground(new java.awt.Color(204, 204, 204));
        btn_3.setFont(new java.awt.Font("DigifaceWide", 1, 18)); // NOI18N
        btn_3.setForeground(new java.awt.Color(51, 51, 51));
        btn_3.setText("3");
        btn_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_3ActionPerformed(evt);
            }
        });

        btn_4.setBackground(new java.awt.Color(204, 204, 204));
        btn_4.setFont(new java.awt.Font("DigifaceWide", 1, 18)); // NOI18N
        btn_4.setForeground(new java.awt.Color(51, 51, 51));
        btn_4.setText("4");
        btn_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_4ActionPerformed(evt);
            }
        });

        btn_5.setBackground(new java.awt.Color(204, 204, 204));
        btn_5.setFont(new java.awt.Font("DigifaceWide", 1, 18)); // NOI18N
        btn_5.setForeground(new java.awt.Color(51, 51, 51));
        btn_5.setText("5");
        btn_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_5ActionPerformed(evt);
            }
        });

        btn_6.setBackground(new java.awt.Color(204, 204, 204));
        btn_6.setFont(new java.awt.Font("DigifaceWide", 1, 18)); // NOI18N
        btn_6.setForeground(new java.awt.Color(51, 51, 51));
        btn_6.setText("6");
        btn_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_6ActionPerformed(evt);
            }
        });

        btn_7.setBackground(new java.awt.Color(204, 204, 204));
        btn_7.setFont(new java.awt.Font("DigifaceWide", 1, 18)); // NOI18N
        btn_7.setForeground(new java.awt.Color(51, 51, 51));
        btn_7.setText("7");
        btn_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_7ActionPerformed(evt);
            }
        });

        btn_8.setBackground(new java.awt.Color(204, 204, 204));
        btn_8.setFont(new java.awt.Font("DigifaceWide", 1, 18)); // NOI18N
        btn_8.setForeground(new java.awt.Color(51, 51, 51));
        btn_8.setText("8");
        btn_8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_8ActionPerformed(evt);
            }
        });

        btn_9.setBackground(new java.awt.Color(204, 204, 204));
        btn_9.setFont(new java.awt.Font("DigifaceWide", 1, 18)); // NOI18N
        btn_9.setForeground(new java.awt.Color(51, 51, 51));
        btn_9.setText("9");
        btn_9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_9ActionPerformed(evt);
            }
        });

        btn_Phay.setBackground(new java.awt.Color(204, 204, 204));
        btn_Phay.setFont(new java.awt.Font("DigifaceWide", 1, 18)); // NOI18N
        btn_Phay.setForeground(new java.awt.Color(51, 51, 51));
        btn_Phay.setText(".");
        btn_Phay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_PhayActionPerformed(evt);
            }
        });

        btnCong.setBackground(new java.awt.Color(0, 102, 102));
        btnCong.setFont(new java.awt.Font("DigifaceWide", 1, 18)); // NOI18N
        btnCong.setForeground(new java.awt.Color(255, 255, 255));
        btnCong.setText("+");
        btnCong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCongActionPerformed(evt);
            }
        });

        btnTru.setBackground(new java.awt.Color(0, 102, 102));
        btnTru.setFont(new java.awt.Font("DigifaceWide", 1, 18)); // NOI18N
        btnTru.setForeground(new java.awt.Color(255, 255, 255));
        btnTru.setText("-");
        btnTru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTruActionPerformed(evt);
            }
        });

        btnNhan.setBackground(new java.awt.Color(0, 102, 102));
        btnNhan.setFont(new java.awt.Font("DigifaceWide", 1, 18)); // NOI18N
        btnNhan.setForeground(new java.awt.Color(255, 255, 255));
        btnNhan.setText("x");
        btnNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhanActionPerformed(evt);
            }
        });

        btnChia.setBackground(new java.awt.Color(0, 102, 102));
        btnChia.setFont(new java.awt.Font("DigifaceWide", 1, 18)); // NOI18N
        btnChia.setForeground(new java.awt.Color(255, 255, 255));
        btnChia.setText("/");
        btnChia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChiaActionPerformed(evt);
            }
        });

        btn_ChiaDu.setBackground(new java.awt.Color(0, 102, 102));
        btn_ChiaDu.setFont(new java.awt.Font("DigifaceWide", 1, 18)); // NOI18N
        btn_ChiaDu.setForeground(new java.awt.Color(255, 255, 255));
        btn_ChiaDu.setText("%");
        btn_ChiaDu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ChiaDuActionPerformed(evt);
            }
        });

        btnBang.setBackground(new java.awt.Color(102, 255, 102));
        btnBang.setFont(new java.awt.Font("DigifaceWide", 1, 24)); // NOI18N
        btnBang.setForeground(new java.awt.Color(255, 255, 255));
        btnBang.setText("=");
        btnBang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBangActionPerformed(evt);
            }
        });

        txtPhepTinh.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        txtPhepTinh.setForeground(new java.awt.Color(204, 0, 35));
        txtPhepTinh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtPhepTinh.setText("NULL");
        txtPhepTinh.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtPhepTinh.setPreferredSize(new java.awt.Dimension(48, 32));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblMayTinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtPhepTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMayTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(btn_0)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btn_Phay, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnChia, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(btn_ChiaDu, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnBang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(btn_1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btn_2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btn_3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnNhan))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(btn_4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btn_5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btn_6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnTru, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(btn_7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btn_8, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btn_9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnCong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAC, btnChia, btnCong, btnNhan, btnTru, btnXoa, btn_0, btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_ChiaDu, btn_Phay});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblMayTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMayTinh)
                    .addComponent(txtPhepTinh, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_7, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_8, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_9, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCong, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTru, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_0, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChia, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAC, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Phay, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_ChiaDu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBang, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAC, btnBang, btnChia, btnCong, btnNhan, btnTru, btnXoa, btn_0, btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_ChiaDu, btn_Phay});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnACActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnACActionPerformed
        txtMayTinh.setText(null);
        txtPhepTinh.setText("NULL");
        firstNumber = 0;
        secondNumber = 0;
        result = 0;
    }//GEN-LAST:event_btnACActionPerformed

    private void btn_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_0ActionPerformed
        String enterNumber = txtMayTinh.getText() + btn_0.getText();
        txtMayTinh.setText(enterNumber);
    }//GEN-LAST:event_btn_0ActionPerformed

    private void btn_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_1ActionPerformed
        String enterNumber = txtMayTinh.getText() + btn_1.getText();
        txtMayTinh.setText(enterNumber);
    }//GEN-LAST:event_btn_1ActionPerformed

    private void btn_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_2ActionPerformed
        String enterNumber = txtMayTinh.getText() + btn_2.getText();
        txtMayTinh.setText(enterNumber);
    }//GEN-LAST:event_btn_2ActionPerformed

    private void btn_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_3ActionPerformed
        String enterNumber = txtMayTinh.getText() + btn_3.getText();
        txtMayTinh.setText(enterNumber);
    }//GEN-LAST:event_btn_3ActionPerformed

    private void btn_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_4ActionPerformed
        String enterNumber = txtMayTinh.getText() + btn_4.getText();
        txtMayTinh.setText(enterNumber);
    }//GEN-LAST:event_btn_4ActionPerformed

    private void btn_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_5ActionPerformed
        String enterNumber = txtMayTinh.getText() + btn_5.getText();
        txtMayTinh.setText(enterNumber);
    }//GEN-LAST:event_btn_5ActionPerformed

    private void btn_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_6ActionPerformed
        String enterNumber = txtMayTinh.getText() + btn_6.getText();
        txtMayTinh.setText(enterNumber);
    }//GEN-LAST:event_btn_6ActionPerformed

    private void btn_7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_7ActionPerformed
        String enterNumber = txtMayTinh.getText() + btn_7.getText();
        txtMayTinh.setText(enterNumber);
    }//GEN-LAST:event_btn_7ActionPerformed

    private void btn_8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_8ActionPerformed
        String enterNumber = txtMayTinh.getText() + btn_8.getText();
        txtMayTinh.setText(enterNumber);
    }//GEN-LAST:event_btn_8ActionPerformed

    private void btn_9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_9ActionPerformed
        String enterNumber = txtMayTinh.getText() + btn_9.getText();
        txtMayTinh.setText(enterNumber);
    }//GEN-LAST:event_btn_9ActionPerformed

    private void btnCongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCongActionPerformed
        if(txtMayTinh.getText().isEmpty()){
            LoiDeTrong();
        }else{
            firstNumber = Double.parseDouble(txtMayTinh.getText());
            txtMayTinh.setText(null);
            operations= "+";
            txtPhepTinh.setText("+");
        }
    }//GEN-LAST:event_btnCongActionPerformed

    private void btnTruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTruActionPerformed
        if(txtMayTinh.getText().isEmpty()){
            LoiDeTrong();
        }else{
            firstNumber = Double.parseDouble(txtMayTinh.getText());
            txtMayTinh.setText(null);
            operations= "-"; 
            txtPhepTinh.setText("-");
        }
    }//GEN-LAST:event_btnTruActionPerformed

    private void btnNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhanActionPerformed
        if(txtMayTinh.getText().isEmpty()){
            LoiDeTrong();
        }else{
            firstNumber = Double.parseDouble(txtMayTinh.getText());
            txtMayTinh.setText(null);
            operations= "*";
            txtPhepTinh.setText("x");
        }
        
    }//GEN-LAST:event_btnNhanActionPerformed

    private void btnChiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChiaActionPerformed
        if(txtMayTinh.getText().isEmpty()){
            LoiDeTrong();
        }else{
            firstNumber = Double.parseDouble(txtMayTinh.getText());
            txtMayTinh.setText(null);
            operations= "/"; 
            txtPhepTinh.setText("/");
        }
    }//GEN-LAST:event_btnChiaActionPerformed

    private void btn_ChiaDuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ChiaDuActionPerformed
        if(txtMayTinh.getText().isEmpty()){
            LoiDeTrong();
        }else{
            firstNumber = Double.parseDouble(txtMayTinh.getText());
            txtMayTinh.setText(null);
            operations= "%";
            txtPhepTinh.setText("%");
        }
        
    }//GEN-LAST:event_btn_ChiaDuActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        String xoa;
        if(txtMayTinh.getText().length() >0 ){
            StringBuilder stbXoa = new StringBuilder(txtMayTinh.getText());
            stbXoa.deleteCharAt(txtMayTinh.getText().length() - 1);
            xoa = stbXoa.toString();
            txtMayTinh.setText(xoa);
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnBangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBangActionPerformed
        if(txtMayTinh.getText().isEmpty()){
            LoiDeTrong();
        }else{
            secondNumber = Double.parseDouble(txtMayTinh.getText());
            if("+".equals(operations)){
                result = firstNumber + secondNumber;
                answer = String.format("%.2f", result);
                txtMayTinh.setText(answer);
            }
            if("-".equals(operations)){
                result = firstNumber - secondNumber;
                answer = String.format("%.2f", result);
                txtMayTinh.setText(answer);
            }
            if("*".equals(operations)){
                result = firstNumber * secondNumber;
                answer = String.format("%.2f", result);
                txtMayTinh.setText(answer);
            }
            if("/".equals(operations)){
                result = firstNumber / secondNumber;
                answer = String.format("%.2f", result);
                txtMayTinh.setText(answer);
            }
            if("%".equals(operations)){
                result = firstNumber % secondNumber;
                answer = String.format("%.2f", result);
                txtMayTinh.setText(answer);
            }
            txtPhepTinh.setText("K.Quả");
        }
    }//GEN-LAST:event_btnBangActionPerformed

    private void txtMayTinhKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMayTinhKeyTyped
        char number = evt.getKeyChar();
        if((!Character.isDigit(number)) || (number == KeyEvent.VK_BACK_SPACE)){
            evt.consume();
        }
    }//GEN-LAST:event_txtMayTinhKeyTyped

    private void btn_PhayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_PhayActionPerformed
        String enterNumber = txtMayTinh.getText() + btn_Phay.getText();
        txtMayTinh.setText(enterNumber);
    }//GEN-LAST:event_btn_PhayActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAC;
    private javax.swing.JButton btnBang;
    private javax.swing.JButton btnChia;
    private javax.swing.JButton btnCong;
    private javax.swing.JButton btnNhan;
    private javax.swing.JButton btnTru;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btn_0;
    private javax.swing.JButton btn_1;
    private javax.swing.JButton btn_2;
    private javax.swing.JButton btn_3;
    private javax.swing.JButton btn_4;
    private javax.swing.JButton btn_5;
    private javax.swing.JButton btn_6;
    private javax.swing.JButton btn_7;
    private javax.swing.JButton btn_8;
    private javax.swing.JButton btn_9;
    private javax.swing.JButton btn_ChiaDu;
    private javax.swing.JButton btn_Phay;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblMayTinh;
    private javax.swing.JTextField txtMayTinh;
    private javax.swing.JLabel txtPhepTinh;
    // End of variables declaration//GEN-END:variables
    public void LoiDeTrong(){
        JOptionPane.showMessageDialog(null,"Vui lòng không để trống !","Lỗi !",JOptionPane.YES_OPTION);
    }
}
