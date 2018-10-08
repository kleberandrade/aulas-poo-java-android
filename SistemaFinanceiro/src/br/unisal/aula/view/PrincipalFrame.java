package br.unisal.aula.view;

import br.unisal.aula.charts.BarChartHelper;
import br.unisal.aula.charts.PieChartHelper;
import br.unisal.aula.models.FluxoCaixa;
import br.unisal.aula.models.ItemFinanceiro;
import br.unisal.aula.models.ItemFinanceiroDAO;
import br.unisal.aula.tables.ItemFinanceiroTableModel;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class PrincipalFrame extends javax.swing.JFrame {

    private ArrayList<ItemFinanceiro> lista;
    private ItemFinanceiroTableModel modelo;
    private FluxoCaixa fluxoCaixa;

    public PrincipalFrame() {
        initComponents();
        inicializar();
        super.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    private void inicializar() {
        lista = new ArrayList<>();
        ItemFinanceiroDAO dao = new ItemFinanceiroDAO();
        lista = dao.buscarTodos();

        fluxoCaixa = new FluxoCaixa(lista);

        modelo = new ItemFinanceiroTableModel(lista);
        itensFinanceirosTable.setModel(modelo);

        atualizarTela();
    }

    private void atualizarTela() {
        limparCampos();
        atualizarFluxoCaixaDaTela();
        atualizarGraficoBarras();
        atualizarGraficoPizza();
    }

    private void atualizarFluxoCaixaDaTela() {
        Locale local = new Locale("pt", "BR");
        NumberFormat formatar = NumberFormat.getCurrencyInstance(local);

        receitaLabel.setText(formatar.format(fluxoCaixa.getReceita()));
        despesaLabel.setText(formatar.format(fluxoCaixa.getDespesa()));
        saldoLabel.setText(formatar.format(fluxoCaixa.getSaldo()));
    }

    private void atualizarGraficoBarras() {
        String[] legendas = {"Receita", "Despesa", "Saldo"};
        double[] valores = {fluxoCaixa.getReceita(), fluxoCaixa.getDespesa(), fluxoCaixa.getSaldo()};
        BarChartHelper.setGraficoNoPainel(BarChartHelper.criarGrafico(legendas, valores), graficoBarraPanel);
    }

    public void atualizarGraficoPizza() {

        int quantidade = categoriaComboBox.getItemCount();
        String[] categorias = new String[quantidade - 1];
        for (int i = 0; i < quantidade - 1; i++) {
            categorias[i] = (String) categoriaComboBox.getItemAt(i);
        }

        PieChartHelper.setGraficoNoPainel(PieChartHelper.criarGrafico((ArrayList<ItemFinanceiro>) lista, categorias), graficoPizzaPanel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        receitaLabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        despesaLabel = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        saldoLabel = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        descricaoTextField = new javax.swing.JTextField();
        tipoComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        categoriaComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        valorTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        dataDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        limparButton = new javax.swing.JButton();
        removerButton = new javax.swing.JButton();
        editarButton = new javax.swing.JButton();
        adicionarButton = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        itensFinanceirosTable = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        graficoBarraPanel = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        graficoPizzaPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Financeiro");

        jPanel1.setBackground(new java.awt.Color(236, 240, 241));

        jPanel2.setBackground(new java.awt.Color(236, 240, 241));
        jPanel2.setLayout(new java.awt.GridLayout(1, 3, 10, 10));

        jPanel3.setBackground(new java.awt.Color(39, 174, 96));
        jPanel3.setLayout(new java.awt.CardLayout(10, 10));

        jPanel7.setBackground(new java.awt.Color(39, 174, 96));

        jLabel9.setBackground(new java.awt.Color(236, 240, 241));
        jLabel9.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(236, 240, 241));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Receita");
        jLabel9.setToolTipText("");

        receitaLabel.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        receitaLabel.setForeground(new java.awt.Color(236, 240, 241));
        receitaLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        receitaLabel.setText("R$ 5000,00");
        receitaLabel.setToolTipText("");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(receitaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(receitaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel7, "card2");

        jPanel2.add(jPanel3);

        jPanel4.setBackground(new java.awt.Color(192, 57, 43));
        jPanel4.setLayout(new java.awt.CardLayout(10, 10));

        jPanel8.setBackground(new java.awt.Color(192, 57, 43));

        jLabel11.setBackground(new java.awt.Color(236, 240, 241));
        jLabel11.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(236, 240, 241));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Despesas");
        jLabel11.setToolTipText("");

        despesaLabel.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        despesaLabel.setForeground(new java.awt.Color(236, 240, 241));
        despesaLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        despesaLabel.setText("R$ 3000,00");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(despesaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(despesaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel8, "card2");

        jPanel2.add(jPanel4);

        jPanel6.setBackground(new java.awt.Color(41, 128, 185));
        jPanel6.setLayout(new java.awt.CardLayout(10, 10));

        jPanel9.setBackground(new java.awt.Color(41, 128, 185));

        jLabel13.setBackground(new java.awt.Color(236, 240, 241));
        jLabel13.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(236, 240, 241));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Saldo");
        jLabel13.setToolTipText("");

        saldoLabel.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        saldoLabel.setForeground(new java.awt.Color(236, 240, 241));
        saldoLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        saldoLabel.setText("R$ 2000,00");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(saldoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saldoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
        );

        jPanel6.add(jPanel9, "card2");

        jPanel2.add(jPanel6);

        jPanel10.setBackground(new java.awt.Color(236, 240, 241));
        jPanel10.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        jPanel11.setBackground(new java.awt.Color(236, 240, 241));
        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(189, 195, 199)));

        jPanel13.setBackground(new java.awt.Color(236, 240, 241));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(44, 62, 80));
        jLabel1.setText("Tipo");

        tipoComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Despesa", "Receita" }));

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(44, 62, 80));
        jLabel3.setText("Descrição");

        categoriaComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Saúde", "Educação", "Tecnologia", "Moradia", "Alimentação", "Transporte", "Lazer", "Outros", " " }));

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(44, 62, 80));
        jLabel4.setText("Categoria");

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(44, 62, 80));
        jLabel5.setText("Valor (R$)");

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(44, 62, 80));
        jLabel6.setText("Data");

        jPanel17.setBackground(new java.awt.Color(236, 240, 241));
        jPanel17.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        limparButton.setText("LIMPAR");
        limparButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparButtonActionPerformed(evt);
            }
        });
        jPanel17.add(limparButton);

        removerButton.setText("REMOVER");
        removerButton.setActionCommand("remover");
        removerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerButtonActionPerformed(evt);
            }
        });
        jPanel17.add(removerButton);

        editarButton.setText("EDITAR");
        editarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarButtonActionPerformed(evt);
            }
        });
        jPanel17.add(editarButton);

        adicionarButton.setText("ADICIONAR");
        adicionarButton.setActionCommand("remover");
        adicionarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarButtonActionPerformed(evt);
            }
        });
        jPanel17.add(adicionarButton);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
                    .addComponent(descricaoTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(tipoComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(categoriaComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dataDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(valorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)))
                    .addComponent(jLabel3))
                .addContainerGap())
        );

        jPanel13Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {dataDateChooser, jLabel5, jLabel6, valorTextField});

        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descricaoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tipoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(valorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dataDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(categoriaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel14.setBackground(new java.awt.Color(236, 240, 241));

        itensFinanceirosTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descrição", "Tipo", "Valor", "Categoria", "Data"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        itensFinanceirosTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itensFinanceirosTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(itensFinanceirosTable);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.add(jPanel11);

        jPanel12.setBackground(new java.awt.Color(236, 240, 241));
        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(189, 195, 199)));
        jPanel12.setLayout(new java.awt.GridLayout(2, 0));

        jPanel15.setBackground(new java.awt.Color(236, 240, 241));
        jPanel15.setLayout(new java.awt.CardLayout(10, 10));

        javax.swing.GroupLayout graficoBarraPanelLayout = new javax.swing.GroupLayout(graficoBarraPanel);
        graficoBarraPanel.setLayout(graficoBarraPanelLayout);
        graficoBarraPanelLayout.setHorizontalGroup(
            graficoBarraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 474, Short.MAX_VALUE)
        );
        graficoBarraPanelLayout.setVerticalGroup(
            graficoBarraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 242, Short.MAX_VALUE)
        );

        jPanel15.add(graficoBarraPanel, "card2");

        jPanel12.add(jPanel15);

        jPanel16.setBackground(new java.awt.Color(236, 240, 241));
        jPanel16.setLayout(new java.awt.CardLayout(10, 10));

        graficoPizzaPanel.setToolTipText("");

        javax.swing.GroupLayout graficoPizzaPanelLayout = new javax.swing.GroupLayout(graficoPizzaPanel);
        graficoPizzaPanel.setLayout(graficoPizzaPanelLayout);
        graficoPizzaPanelLayout.setHorizontalGroup(
            graficoPizzaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 474, Short.MAX_VALUE)
        );
        graficoPizzaPanelLayout.setVerticalGroup(
            graficoPizzaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 242, Short.MAX_VALUE)
        );

        jPanel16.add(graficoPizzaPanel, "card2");

        jPanel12.add(jPanel16);

        jPanel10.add(jPanel12);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1038, 717));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private ItemFinanceiro getItemDaTela() {
        String descricao = descricaoTextField.getText();
        String tipo = String.valueOf(tipoComboBox.getSelectedItem());
        double valor = Double.parseDouble(valorTextField.getText());
        String categoria = String.valueOf(categoriaComboBox.getSelectedItem());
        Date data = dataDateChooser.getDate();

        ItemFinanceiro item = new ItemFinanceiro(descricao, tipo, valor, categoria, data);

        return item;
    }

    private void adicionarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarButtonActionPerformed
        ItemFinanceiro item = getItemDaTela();

        ItemFinanceiroDAO dao = new ItemFinanceiroDAO();
        dao.inserir(item);
        
        fluxoCaixa.registrarItemFinanceiro(item);

        modelo.adicionar(item);
        atualizarTela();
    }//GEN-LAST:event_adicionarButtonActionPerformed

    private void limparButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparButtonActionPerformed
        limparCampos();
    }//GEN-LAST:event_limparButtonActionPerformed

    private void itensFinanceirosTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itensFinanceirosTableMouseClicked
        int linhaSelecionada = itensFinanceirosTable.getSelectedRow();
        if (linhaSelecionada >= 0) {
            ItemFinanceiro item = modelo.getItem(linhaSelecionada);
            descricaoTextField.setText(item.getDescricao());
            valorTextField.setText(String.valueOf(item.getValor()));
            tipoComboBox.setSelectedItem(item.getTipo());
            categoriaComboBox.setSelectedItem(item.getCategoria());
            dataDateChooser.setDate(item.getData());
        }
    }//GEN-LAST:event_itensFinanceirosTableMouseClicked

    private void removerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerButtonActionPerformed
        int linhaSelecionada = itensFinanceirosTable.getSelectedRow();
        if (linhaSelecionada >= 0) {

            ItemFinanceiro item = getItemDaTela();
            item.setId((long)modelo.getValueAt(linhaSelecionada, 0));
            
            ItemFinanceiroDAO dao = new ItemFinanceiroDAO();
            dao.excluir(item);

            fluxoCaixa.removerItemFinanceiro(item);
            
            modelo.excluir(linhaSelecionada);
            atualizarTela();
        } else {
            JOptionPane.showMessageDialog(this, "É necessário selecionar uma linha.");
        }

    }//GEN-LAST:event_removerButtonActionPerformed

    private void editarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarButtonActionPerformed
        int linhaSelecionada = itensFinanceirosTable.getSelectedRow();
        if (linhaSelecionada >= 0) {
            ItemFinanceiro item = getItemDaTela();
            item.setId((long)modelo.getValueAt(linhaSelecionada, 0));
            
            ItemFinanceiroDAO dao = new ItemFinanceiroDAO();
            dao.atualizar(item);

            fluxoCaixa.atualizarItensFinanceiros(lista);
            
            modelo.atualizar(linhaSelecionada, item);
            atualizarTela();
        } else {
            JOptionPane.showMessageDialog(this, "É necessário selecionar uma linha.");
        }
    }//GEN-LAST:event_editarButtonActionPerformed

    private void limparCampos() {
        descricaoTextField.setText("");
        valorTextField.setText("");
        tipoComboBox.setSelectedIndex(0);
        categoriaComboBox.setSelectedIndex(0);
        dataDateChooser.setDate(new Date());
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PrincipalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adicionarButton;
    private javax.swing.JComboBox categoriaComboBox;
    private com.toedter.calendar.JDateChooser dataDateChooser;
    private javax.swing.JTextField descricaoTextField;
    private javax.swing.JLabel despesaLabel;
    private javax.swing.JButton editarButton;
    private javax.swing.JPanel graficoBarraPanel;
    private javax.swing.JPanel graficoPizzaPanel;
    private javax.swing.JTable itensFinanceirosTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton limparButton;
    private javax.swing.JLabel receitaLabel;
    private javax.swing.JButton removerButton;
    private javax.swing.JLabel saldoLabel;
    private javax.swing.JComboBox tipoComboBox;
    private javax.swing.JTextField valorTextField;
    // End of variables declaration//GEN-END:variables
}
