package view;

import dao.*;
import model.*;
import util.JPAUtil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.swing.*;

public class FlixJanelaPrincipal implements ActionListener {
    JMenuItem
            conteudosCadastrar, categoriaCadastrar, classificacaoCadastrar, tipoConteudoCadastrar, usuarioCadastrar, planoCadastrar, perfilCadastrar, tipoPagamentoCadastrar,
            conteudosConsultar, categoriaConsultar, classificacaoConsultar, tipoConteudoConsultar, usuarioConsultar, planoConsultar, perfilConsultar, tipoPagamentoConsultar,
            conteudosEditar, categoriaEditar, classificacaoEditar, tipoConteudoEditar, usuarioEditar, planoEditar, perfilEditar, tipoPagamentoEditar;
    JMenuItem
            helpMenuItem, sairMenuItem;
    static String resultado;

    public FlixJanelaPrincipal() {

        JFrame f = new JFrame("FLIX");
        f.setTitle("FLIX");
        f.setSize(400, 400);
        f.setLocationRelativeTo(null);

        // Cria uma barra de menu para o JFrame
        JMenuBar menuPrincipal = new JMenuBar();

        // Adiciona a barra de menu ao  frame
        f.setJMenuBar(menuPrincipal);

        // Define e adiciona dois menus drop down na barra de menus
        JMenu cadastroMenu = new JMenu("Cadastro");
        JMenu consultarMenu = new JMenu("Consultar");
        JMenu editMenu = new JMenu("Editar");

//Se��o Cadastro
        //Itens relacionados aos Conte�dos
        JMenu menuConteudo = new JMenu("Conte�do");
        conteudosCadastrar = new JMenuItem("Conte�dos");
        categoriaCadastrar = new JMenuItem("Categoria");
        classificacaoCadastrar = new JMenuItem("Classifica��o");
        tipoConteudoCadastrar = new JMenuItem("Tipo de Conte�do");

        //Itens relacionados aos Usu�rios
        JMenu menuUsuario = new JMenu("Usu�rios");
        usuarioCadastrar = new JMenuItem("Usu�rios");
        planoCadastrar = new JMenuItem("Planos");
        perfilCadastrar = new JMenuItem("Perfis");
        tipoPagamentoCadastrar = new JMenuItem("Formas de Pagamento");

        //Itens Sair e Help
        helpMenuItem = new JMenuItem("Ajuda");
        sairMenuItem = new JMenuItem("Sair");

        //Adicionando  Menu Conteudo ao Menu Principal

        menuConteudo.add(conteudosCadastrar);
        menuConteudo.add(categoriaCadastrar);
        menuConteudo.add(classificacaoCadastrar);
        menuConteudo.add(tipoConteudoCadastrar);
        cadastroMenu.add(menuConteudo);

        //Adicionando  Menu Usuario ao Menu Principal
        menuUsuario.add(usuarioCadastrar);
        menuUsuario.add(planoCadastrar);
        menuUsuario.add(perfilCadastrar);
        menuUsuario.add(tipoPagamentoCadastrar);
        cadastroMenu.add(menuUsuario);

        //add a��es
        conteudosCadastrar.addActionListener(this);
        categoriaCadastrar.addActionListener(this);
        classificacaoCadastrar.addActionListener(this);
        tipoConteudoCadastrar.addActionListener(this);

        usuarioCadastrar.addActionListener(this);
        planoCadastrar.addActionListener(this);
        perfilCadastrar.addActionListener(this);
        tipoPagamentoCadastrar.addActionListener(this);
//Fim se��o cadastro

//Se��o Consulta
        //Itens relacionados aos Consulta
        JMenu menuConteudoConsulta = new JMenu("Conte�do");
        conteudosConsultar = new JMenuItem("Conte�dos");
        categoriaConsultar = new JMenuItem("Categoria");
        classificacaoConsultar = new JMenuItem("Classifica��o");
        tipoConteudoConsultar = new JMenuItem("Tipo de Conte�do");

        //Itens relacionados aos Consulta
        JMenu menuUsuarioConsulta = new JMenu("Usu�rios");
        usuarioConsultar = new JMenuItem("Usu�rios");
        planoConsultar = new JMenuItem("Planos");
        perfilConsultar = new JMenuItem("Perfis");
        tipoPagamentoConsultar = new JMenuItem("Formas de Pagamento");

        //Adicionando  Menu Consulta  ao Menu Principal
        menuConteudoConsulta.add(conteudosConsultar);
        menuConteudoConsulta.add(categoriaConsultar);
        menuConteudoConsulta.add(classificacaoConsultar);
        menuConteudoConsulta.add(tipoConteudoConsultar);
        consultarMenu.add(menuConteudoConsulta);

        //Adicionando  Menu Usuario ao Menu Principal
        menuUsuarioConsulta.add(usuarioConsultar);
        menuUsuarioConsulta.add(planoConsultar);
        menuUsuarioConsulta.add(perfilConsultar);
        menuUsuarioConsulta.add(tipoPagamentoConsultar);
        consultarMenu.add(menuUsuarioConsulta);

        //add a��es
        conteudosConsultar.addActionListener(this);
        categoriaConsultar.addActionListener(this);
        classificacaoConsultar.addActionListener(this);
        tipoConteudoConsultar.addActionListener(this);

        usuarioConsultar.addActionListener(this);
        planoConsultar.addActionListener(this);
        perfilConsultar.addActionListener(this);
        tipoPagamentoConsultar.addActionListener(this);
//Fim Se��o Consulta

//Se��o Editar
        //Itens relacionados aos Consulta
        JMenu menuConteudoEditar = new JMenu("Conte�do");
        conteudosEditar = new JMenuItem("Conte�dos");
        categoriaEditar = new JMenuItem("Categoria");
        classificacaoEditar = new JMenuItem("Classifica��o");
        tipoConteudoEditar = new JMenuItem("Tipo de Conte�do");

        //Itens relacionados ao Usuario
        JMenu menuUsuarioEditar = new JMenu("Usu�rios");
        usuarioEditar = new JMenuItem("Usu�rios");
        planoEditar = new JMenuItem("Planos");
        perfilEditar = new JMenuItem("Perfis");
        tipoPagamentoEditar = new JMenuItem("Formas de Pagamento");

        //Adicionando  Menu Consulta  ao Menu Principal
        menuConteudoEditar.add(conteudosEditar);
        menuConteudoEditar.add(categoriaEditar);
        menuConteudoEditar.add(classificacaoEditar);
        menuConteudoEditar.add(tipoConteudoEditar);
        editMenu.add(menuConteudoEditar);

        //Adicionando  Menu Usuario ao Menu Principal
        menuUsuarioEditar.add(usuarioEditar);
        menuUsuarioEditar.add(planoEditar);
        menuUsuarioEditar.add(perfilEditar);
        menuUsuarioEditar.add(tipoPagamentoEditar);
        editMenu.add(menuUsuarioEditar);

        //add a��es
        conteudosEditar.addActionListener(this);
        categoriaEditar.addActionListener(this);
        classificacaoEditar.addActionListener(this);
        tipoConteudoEditar.addActionListener(this);

        usuarioEditar.addActionListener(this);
        planoEditar.addActionListener(this);
        perfilEditar.addActionListener(this);
        tipoPagamentoEditar.addActionListener(this);
//Fim Se��o Editar

//Se��o Ajuda

        //Itens relacionados aos Consulta
        JMenu menuAjuda = new JMenu("Ajuda");
        helpMenuItem = new JMenuItem("Ajuda");

        //Adicionando  Menu Ajuda  ao Menu Principal
        menuAjuda.add(helpMenuItem);

        //add a��o ao Menu Ajuda
        helpMenuItem.addActionListener(this);

//Se��o Sair

        //Itens relacionados aos Consulta
        JMenu menuExit = new JMenu("Sair");
        sairMenuItem = new JMenuItem("Sair");

        //Adicionando  Menu Ajuda  ao Menu Principal
        menuExit.add(sairMenuItem);

        //add a��o ao Menu Ajuda
        sairMenuItem.addActionListener(this);

// Add itens e submenus ao menuprincipal
        menuPrincipal.add(cadastroMenu);
        menuPrincipal.add(consultarMenu);
        menuPrincipal.add(editMenu);
        menuPrincipal.add(menuAjuda);
        menuPrincipal.add(menuExit);

// Configura��es do Frame
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Consultar
        if (e.getSource() == conteudosConsultar) {

            String resultado = consultarConteudo();
            JOptionPane.showMessageDialog(null, resultado);

        } else if (e.getSource() == categoriaConsultar) {

            String resultado = consultarCategoria();
            JOptionPane.showMessageDialog(null, resultado);

        } else if (e.getSource() == classificacaoConsultar) {

            String resultado = consultarClassificacao();
            JOptionPane.showMessageDialog(null, resultado);

        } else if (e.getSource() == tipoConteudoConsultar) {

            JOptionPane.showMessageDialog(null, consultarTipoConteudo());

        } else if (e.getSource() == usuarioConsultar) {

            //JOptionPane.showMessageDialog(null, consultarUsuario());
            JOptionPane.showMessageDialog(null, consultarUsuarioSimplificado());

        } else if (e.getSource() == planoConsultar) {

            JOptionPane.showMessageDialog(null, consultarPlano());

        } else if (e.getSource() == perfilConsultar) {

            JOptionPane.showMessageDialog(null, "'IDENTIFIQUE' a seguir o ID do Usu�rio para qual deseja consultar os PERFILS");
            JOptionPane.showMessageDialog(null, consultarUsuarioSimplificado());

            int idUsuario = Integer.parseInt(JOptionPane.showInputDialog("'DIGITE' o ID do Usu�rio para qual deseja cadastrar o Perfil"));
            //consultarPerfisPorId(int IdUsuario)

            JOptionPane.showMessageDialog(null, "Estes s�o os Perfils cadastrados para o Usu�rio informado: ");
            JOptionPane.showMessageDialog(null, consultarPerfilporId(idUsuario));

        } else if (e.getSource() == tipoPagamentoConsultar) {

            JOptionPane.showMessageDialog(null, consultarFormaPagamento());

        } else
            //Editar
            if (e.getSource() == conteudosEditar) {

                editarConteudo();
                JOptionPane.showMessageDialog(null,
                        "Conte�do alterado com sucesso!");

            } else if (e.getSource() == categoriaEditar) {

                editarCategoria();
                JOptionPane.showMessageDialog(null,
                        "Categoria alterada com sucesso!");

            } else if (e.getSource() == classificacaoEditar) {

                editarClassificacao();
                JOptionPane.showMessageDialog(null,
                        "Classificacao alterada com sucesso!");

            } else if (e.getSource() == tipoConteudoEditar) {

                editarTipoConteudo();
                JOptionPane.showMessageDialog(null,
                        "'Tipo de Conte�do' alterado com sucesso!");
                JOptionPane.showMessageDialog(null, consultarTipoConteudo());

            } else if (e.getSource() == usuarioEditar) {

                editarUsuario();
                JOptionPane.showMessageDialog(null,
                        "'Usu�rio' alterado com sucesso!");
                JOptionPane.showMessageDialog(null, consultarUsuario());

            } else if (e.getSource() == planoEditar) {
                editarPlano();
                JOptionPane.showMessageDialog(null,
                        "'Plano' alterado com sucesso!");
                JOptionPane.showMessageDialog(null, consultarPlano());

            } else if (e.getSource() == perfilEditar) {
                editarPerfil();

            } else if (e.getSource() == tipoPagamentoEditar) {

                editarFormaPagamento();
                JOptionPane.showMessageDialog(null,
                        "'Forma de Pagamento' alterada com sucesso!");
                JOptionPane.showMessageDialog(null, consultarFormaPagamento());

            } else if (e.getSource() == conteudosCadastrar) {                 //Cadastrar

                int idEpisodio = Integer.parseInt(JOptionPane.showInputDialog("Insira o 'n�mero do epis�dio' <Caso seja filme, digite '0'>"));
                int idTemporada = Integer.parseInt(JOptionPane.showInputDialog("Insira o 'n�mero da temporada' <Caso seja filme, digite '0'>"));
                int idSerie = Integer.parseInt(JOptionPane.showInputDialog("Digite o Identificador da s�rie <Caso seja filme, digite '0'>"));
                int idClassificacao = Integer.parseInt(JOptionPane.showInputDialog("Insira o ID da Classifica��o Indicativa"));
                int idCategoria = Integer.parseInt(JOptionPane.showInputDialog("Insira o ID da Categoria"));
                int idTipoConteudo = Integer.parseInt(JOptionPane.showInputDialog("Insira o ID do tipo de Conteudo"));
                String nome = JOptionPane.showInputDialog("Digite o nome do Filme ou do Ep�s�dio: ");
                String nomeSerie = JOptionPane.showInputDialog("Digite o nome da serie, caso exista: ");
                String sinopse = JOptionPane.showInputDialog("Insira a sinopse do filme ou do epis�dio: ");
                String dataExpiracao = JOptionPane.showInputDialog("Insira a data de expira��o: ");
                int anoLancamento = Integer.parseInt(JOptionPane.showInputDialog("Insira o ano de lan�amento: "));
                String duracao = JOptionPane.showInputDialog("Insira o tempo de dura��o");

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

                Date dataExpiracaoCv = null;

                try {
                    dataExpiracaoCv = dateFormat.parse(dataExpiracao);
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }

                cadastrarConteudo(idEpisodio, idTemporada, idSerie, idClassificacao, idCategoria, idTipoConteudo, nome, nomeSerie, sinopse, dataExpiracaoCv, anoLancamento, duracao);
                JOptionPane.showMessageDialog(null, "Conte�do cadastrado com sucesso!");
            } else if (e.getSource() == categoriaCadastrar) {

                String descricaoCategoria = JOptionPane.showInputDialog("Insira a categoria VARCHAR(45): ");
                cadastrarCategoria(descricaoCategoria);
                if (descricaoCategoria.isBlank()) {
                    JOptionPane.showMessageDialog(null, "N�o foi cadastrada a categoria, verificar registros!");
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Nova categoria inserida!");
                }

            } else if (e.getSource() == classificacaoCadastrar) {
                String descricaoClassificacao = JOptionPane.showInputDialog("Insira a classifica��o VARCHAR(3): ");
                cadastrarClassificacao(descricaoClassificacao);
                if (descricaoClassificacao.isBlank()) {
                    JOptionPane.showMessageDialog(null, "N�o foi cadastrada a classifica��o, verificar registros!");
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Nova classifica��o inserida!");
                }
            } else if (e.getSource() == tipoConteudoCadastrar) {

                String descricaoTipoConteudo = JOptionPane.showInputDialog("Insira a descri��o do tipo de Conte�do VARCHAR(45): ");
                cadastrarTipoConteudo(descricaoTipoConteudo);
                if (descricaoTipoConteudo.isBlank()) {
                    JOptionPane.showMessageDialog(null, "N�o foi cadastrada o tipo de conte�do, verificar registros!");
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Novo tipo de conte�do inserida!");
                }

            } else if (e.getSource() == usuarioCadastrar) {

                String nomeUsuario = JOptionPane.showInputDialog("Digite o nome completo do usu�rio: ");
                String email = JOptionPane.showInputDialog("Digite o email do usuario: ");
                JOptionPane.showMessageDialog(null, "Formas de Pagamento, identifique o <ID> desejado: ");
                JOptionPane.showMessageDialog(null, consultarFormaPagamento());
                int formaPagamento = Integer.parseInt(JOptionPane.showInputDialog("Digite o <ID> desejado: "));
                JOptionPane.showMessageDialog(null, "Planos dispon�veis, identifique o <ID> desejado: ");
                JOptionPane.showMessageDialog(null, consultarPlano());
                int plano = Integer.parseInt(JOptionPane.showInputDialog("Digite o <ID> do plano desejado: "));

                cadastrarUsuario(formaPagamento, email, nomeUsuario, plano);
                JOptionPane.showMessageDialog(null, "Usu�rio cadastrado com sucesso!");

            } else if (e.getSource() == planoCadastrar) {

                String descricaoPlano = JOptionPane.showInputDialog("Insira a descri��o do 'Plano' VARCHAR(45): ");
                cadastrarPlano(descricaoPlano);
                if (descricaoPlano.isBlank()) {
                    JOptionPane.showMessageDialog(null, "N�o foi cadastrada o novo tipo de Plano, verificar registros!");
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Novo 'Plano' inserido!");
                }
                JOptionPane.showMessageDialog(null, consultarPlano());

            } else if (e.getSource() == perfilCadastrar) {


                JOptionPane.showMessageDialog(null, "'IDENTIFIQUE' o ID do Usu�rio para qual deseja cadastrar o PERFIL");
                JOptionPane.showMessageDialog(null, consultarUsuarioSimplificado());

                int idUsuario = Integer.parseInt(JOptionPane.showInputDialog("'DIGITE' o ID do Usu�rio para qual deseja cadastrar o Perfil"));
                //consultarPerfisPorId(int IdUsuario)

                JOptionPane.showMessageDialog(null, "Estes s�o os Perfils cadastrados para o Usu�rio informado: ");
                JOptionPane.showMessageDialog(null, consultarPerfilporId(idUsuario));

                int idPerfil = Integer.parseInt(JOptionPane.showInputDialog("'DIGITE' o ID do perfil a ser cadastrado"));
                //procurarUltimo-BuscarInfo  (select id from table order by id desc limit 1)

                String nickname = JOptionPane.showInputDialog("Digite o nome do perfil");
                boolean kids_profile = Boolean.parseBoolean(JOptionPane.showInputDialog("Informe se o perfil � infantil <1> Sim <0>N�o "));

                cadastrarPerfil(idUsuario, idPerfil, nickname, kids_profile);
                JOptionPane.showMessageDialog(null, "Perfil cadastrado com sucesso!");


            } else if (e.getSource() == tipoPagamentoCadastrar) {

                String descricaoFormaPagamento = JOptionPane.showInputDialog("Insira a nova 'forma de pagamento' VARCHAR(45): ");
                cadastrarFormaPagamento(descricaoFormaPagamento);
                if (descricaoFormaPagamento.isBlank()) {
                    JOptionPane.showMessageDialog(null, "N�o foi cadastrada a forma de pagamento, verificar registros!");
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Nova 'FORMA DE PAGAMENTO' cadastrada!");
                }
                JOptionPane.showMessageDialog(null, consultarFormaPagamento());

            } else if (e.getSource() == sairMenuItem) {
                JOptionPane.showMessageDialog(null, "O sistema ser� encerrado!");
                System.exit(0);

            } else if (e.getSource() == helpMenuItem) {
                JOptionPane.showMessageDialog(null, "Ol�, sou um projeto desenvolvido para cadastro!\n" +
                        "Em caso de d�vidas, abrir chamado para contato@flix");
            } else {
                JOptionPane.showMessageDialog(null, "Op��o ainda implementada!");
            }
    }

    private static void cadastrarClassificacao(String descricaoClassificacao) {

        Classificacao classificacao = new Classificacao(descricaoClassificacao);

        //Conexao com o banco
        EntityManager em = JPAUtil.getEntityManager();
        ClassificacaoDao classificacaoDao = new ClassificacaoDao(em);

        //Incializa a transacao
        em.getTransaction().begin();

        //m�todo para cadastrar no banco
        classificacaoDao.cadastrar(classificacao);

        //valida a transa��o
        em.getTransaction().commit();

        //fecha a conexao com o banco
        em.close();
    }

    private static String consultarClassificacao() {
        //Fazendo conexao com o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        ClassificacaoDao dao = new ClassificacaoDao(em);

        List<Classificacao> todasClassificao = dao.consultarTodos();
        int tam = todasClassificao.size();
        resultado = "Estas s�o as classifica��es: \n";
        //Concatenar todas as classificacoes no resultado
        for (int i = 0; i < tam; i++) {
            resultado += todasClassificao.get(i).getIdClassificacao() + " - " +
                    todasClassificao.get(i).getClassificacao() + "\n";
        }
        return resultado;
    }

    private static void editarClassificacao() {

        //Fazendo conexao com o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        ClassificacaoDao dao = new ClassificacaoDao(em);

        resultado = consultarClassificacao();
        int id = Integer.parseInt(JOptionPane.showInputDialog(resultado + "\n" +
                "Qual classificacao deseja alterar? "));
        String classificacao = JOptionPane.showInputDialog("Qual a descricacao da classificacao VARCHAR(3)?");

        //Incializa a transacao
        em.getTransaction().begin();

        // passando as vari�veis como par�metro

        Classificacao classificacaoAlterar = dao.buscarPorId(id);

        dao.alterarClassificacao(classificacaoAlterar);
        classificacaoAlterar.setClassificacao(classificacao);

        //valida a transa��o
        em.getTransaction().commit();

        //fecha a conexao com o banco
        em.close();

    }

    //CadastroCategoria
    private static void cadastrarCategoria(String descricaoCategoria) {

        Categoria categoria = new Categoria(descricaoCategoria);

        //Conexao com o banco
        EntityManager em = JPAUtil.getEntityManager();
        CategoriaDao categoriaDao = new CategoriaDao(em);

        //Incializa a transacao
        em.getTransaction().begin();

        //m�todo para cadastrar no banco
        categoriaDao.cadastrar(categoria);

        //valida a transa��o
        em.getTransaction().commit();

        //fecha a conexao com o banco
        em.close();
    }

    //ConsultaCategoria
    private static String consultarCategoria() {
        //Fazendo conexao com o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        CategoriaDao dao = new CategoriaDao(em);

        List<Categoria> todasCategoria = dao.consultarTodos();
        int tam = todasCategoria.size();
        resultado = "Estas s�o as categorias: \n";
        //Concatenar todas as categorias no resultado
        for (int i = 0; i < tam; i++) {
            resultado += todasCategoria.get(i).getIdCategoria() + " - " +
                    todasCategoria.get(i).getCategoria() + "\n";
        }
        return resultado;
    }

    //Editar Categoria
    private static void editarCategoria() {

        //Fazendo conexao com o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        CategoriaDao dao = new CategoriaDao(em);

        resultado = consultarCategoria();
        int id = Integer.parseInt(JOptionPane.showInputDialog(resultado + "\n" +
                "Qual categoria deseja alterar? "));
        String categoria = JOptionPane.showInputDialog("Qual a descricacao da categoria VARCHAR(45)?");

        //Incializa a transacao
        em.getTransaction().begin();

        // passando as vari�veis como par�metro

        Categoria categoriaAlterar = dao.buscarPorId(id);

        dao.alterarCategoria(categoriaAlterar);
        categoriaAlterar.setCategoria(categoria);

        //valida a transa��o
        em.getTransaction().commit();

        //fecha a conexao com o banco
        em.close();

    }

    //CadastroTipoConteudo

    private static void cadastrarTipoConteudo(String descricaoTipoConteudo) {

        TipoConteudo tipoConteudo = new TipoConteudo(descricaoTipoConteudo);

        //Conexao com o banco
        EntityManager em = JPAUtil.getEntityManager();
        TipoConteudoDao tipoConteudoDao = new TipoConteudoDao(em);

        //Incializa a transacao
        em.getTransaction().begin();

        //m�todo para cadastrar no banco
        tipoConteudoDao.cadastrar(tipoConteudo);

        //valida a transa��o
        em.getTransaction().commit();

        //fecha a conexao com o banco
        em.close();
    }

    //ConsultarTipoConteudo

    private static String consultarTipoConteudo() {
        //Fazendo conexao com o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        TipoConteudoDao dao = new TipoConteudoDao(em);

        List<TipoConteudo> todosTiposConteudo = dao.consultarTodos();
        int tam = todosTiposConteudo.size();
        resultado = "Estes s�o os tipos de conte�dos: \n";
        //Concatenar todas as categorias no resultado
        for (int i = 0; i < tam; i++) {
            resultado += todosTiposConteudo.get(i).getIdTipoConteudo() + " - " +
                    todosTiposConteudo.get(i).getTipoConteudo() + "\n";
        }
        return resultado;
    }

    //EditarTipoConteudo

    private static void editarTipoConteudo() {

        //Fazendo conexao com o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        TipoConteudoDao dao = new TipoConteudoDao(em);

        resultado = consultarTipoConteudo();
        int id = Integer.parseInt(JOptionPane.showInputDialog(resultado + "\n" +
                "Qual 'tipo de conte�do' deseja alterar? "));

        String categoria = JOptionPane.showInputDialog("Qual o tipo de conte�do 'VARCHAR(45)'?");

        //Incializa a transacao
        em.getTransaction().begin();

        // passando as vari�veis como par�metro

        TipoConteudo tipoConteudoAlterar = dao.buscarPorId(id);

        dao.alterarTipoConteudo(tipoConteudoAlterar);
        tipoConteudoAlterar.setTipoConteudo(categoria);

        //valida a transa��o
        em.getTransaction().commit();

        //fecha a conexao com o banco
        em.close();

    }

    //Cadastro Formas de Pagamento

    private static void cadastrarFormaPagamento(String descricaoFormaPagamento) {

        FormaPagamento formaPagamento = new FormaPagamento(descricaoFormaPagamento);

        //Conexao com o banco
        EntityManager em = JPAUtil.getEntityManager();
        FormaPagamentoDao formaPagamentoDao = new FormaPagamentoDao(em);

        //Incializa a transacao
        em.getTransaction().begin();

        //m�todo para cadastrar no banco
        formaPagamentoDao.cadastrar(formaPagamento);

        //valida a transa��o
        em.getTransaction().commit();

        //fecha a conexao com o banco
        em.close();
    }

    //Consulta Formas de Pagamento

    private static String consultarFormaPagamento() {
        //Fazendo conexao com o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        FormaPagamentoDao formaPagamentoDao = new FormaPagamentoDao(em);

        List<FormaPagamento> todasFormasPagamento = formaPagamentoDao.consultarTodos();
        int tam = todasFormasPagamento.size();
        resultado = "Estes s�o os tipos de conte�dos: \n";
        //Concatenar todas as categorias no resultado
        for (int i = 0; i < tam; i++) {
            resultado += todasFormasPagamento.get(i).getIdFormaPagamento() + " - " +
                    todasFormasPagamento.get(i).getFormaPagamento() + "\n";
        }
        return resultado;
    }

    //Editar Formas de Pagamento
    private static void editarFormaPagamento() {

        //Fazendo conexao com o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        FormaPagamentoDao formapagamentodao = new FormaPagamentoDao(em);

        resultado = consultarFormaPagamento();
        int id;

        //Placeholder no campo pr�-preenchida
        FormaPagamento formaPagamentoBusca = null;
        id = 0;
        do {
            resultado = consultarFormaPagamento();
            id = Integer.parseInt(JOptionPane.showInputDialog(resultado + "\n" +
                    "Qual 'Plano' deseja alterar? "));
            formaPagamentoBusca = FormaPagamentoDao.buscarPorId(id);
        } while (formaPagamentoBusca == null);

        //Placeholder no campo pr�-preenchida
        String formaPagamento = formaPagamentoBusca.getFormaPagamento();
        formaPagamento = JOptionPane.showInputDialog("Qual a descri��o do 'PLANO' (VARCHAR(45))?", formaPagamento); //valor de inicializa��o da mensagem

        //Incializa a transacao
        em.getTransaction().begin();

        // passando as vari�veis como par�metro

        FormaPagamento formaPagamentoAlterar = formapagamentodao.buscarPorId(id);

        formapagamentodao.alterarFormaPagamento(formaPagamentoAlterar);
        formaPagamentoAlterar.setFormaPagamento(formaPagamento);

        //valida a transa��o
        em.getTransaction().commit();

        //fecha a conexao com o banco
        em.close();
    }

    //PLANOS

    //Consultar Planos
    private static String consultarPlano() {
        //Fazendo conexao com o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        PlanoDao planoDao = new PlanoDao(em);

        List<Plano> todosPlanos = planoDao.consultarTodos();
        int tam = todosPlanos.size();
        resultado = "Estes s�o os planos dispon�veis: \n";
        //Concatenar todas as categorias no resultado
        for (int i = 0; i < tam; i++) {
            resultado += todosPlanos.get(i).getIdPlano() + " - " +
                    todosPlanos.get(i).getPlano() + "\n";
        }
        return resultado;
    }

    //Cadastrar Planos
    private static void cadastrarPlano(String descricaoPlano) {

        Plano plano = new Plano(descricaoPlano);

        //Conexao com o banco
        EntityManager em = JPAUtil.getEntityManager();
        PlanoDao planoDao = new PlanoDao(em);

        //Incializa a transacao
        em.getTransaction().begin();

        //m�todo para cadastrar no banco
        planoDao.cadastrar(plano);

        //valida a transa��o
        em.getTransaction().commit();

        //fecha a conexao com o banco
        em.close();
    }

    //Editar Planos
    private static void editarPlano() {

        //Fazendo conexao com o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        PlanoDao planoDao = new PlanoDao(em);

        Plano planoBusca = null;
        int id = 0;
        do {
            resultado = consultarPlano();
            id = Integer.parseInt(JOptionPane.showInputDialog(resultado + "\n" +
                    "Qual 'Plano' deseja alterar? "));
            planoBusca = planoDao.buscarPorId(id);
        } while (planoBusca == null);

        //Placeholder no campo pr�-preenchida
        String plano = planoBusca.getPlano();
        plano = JOptionPane.showInputDialog("Qual a descri��o do 'PLANO' (VARCHAR(45))?", plano); //valor de inicializa��o da mensagem

        //Incializa a transacao
        em.getTransaction().begin();

        // passando as vari�veis como par�metro

        Plano planoAlterar = planoDao.buscarPorId(id);

        planoDao.alterarPlano(planoAlterar);
        planoAlterar.setPlano(plano);

        //valida a transa��o
        em.getTransaction().commit();

        //fecha a conexao com o banco
        em.close();
    }

    //Portf�lio

    //Consultar Portf�lio

    private static String consultarConteudo() {
        //Fazendo conexao com o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        PortfolioDao portfolioDao = new PortfolioDao(em);

        List<Portfolio> todosPortfolios = portfolioDao.consultarTodos();
        int tam = todosPortfolios.size();
        resultado = "Estes s�o os conte�dos dispon�veis: \n";
        String conteudo = "";
        //Concatenar todas as categorias no resultado
        for (int i = 0; i < tam; i++) {
            if (todosPortfolios.get(i).getTipoConteudo() == 1) {
                conteudo = "[Filme]";
            } else {
                conteudo = "[S�rie]";
            }
            resultado += conteudo + " - " + todosPortfolios.get(i).getIdVideo() + " - " +
                    todosPortfolios.get(i).getNome() + "\n";
        }
        return resultado;
    }
    //Cadastrar Portf�lio

    private static void cadastrarConteudo(int idEpisodio, int idTemporada, int idSerie, int idClassificacao, int idCategoria, int tipoConteudo,
                                          String nome, String nomeSerie, String sinopse, Date dataExpiracao, int anoLancamento, String duracao) {
        Portfolio portfolio = new Portfolio(idEpisodio, idTemporada, idSerie, idClassificacao, idCategoria, tipoConteudo,
                nome, nomeSerie, sinopse, dataExpiracao, anoLancamento, duracao);

        //Conexao com o banco
        EntityManager em = JPAUtil.getEntityManager();
        PortfolioDao portfolioDao = new PortfolioDao(em);

        //Incializa a transacao
        em.getTransaction().begin();

        //m�todo para cadastrar no banco
        portfolioDao.cadastrar(portfolio);

        //valida a transa��o
        em.getTransaction().commit();

        //fecha a conexao com o banco
        em.close();
    }

    //Editar Portf�lio
    private static void editarConteudo() {

        //Fazendo conexao com o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        PortfolioDao portfolioDao = new PortfolioDao(em);

        resultado = consultarConteudo();

        int id = Integer.parseInt(JOptionPane.showInputDialog(resultado + "\n" +
                "Qual 'Conteudo' deseja alterar? <Selecione a ID> "));

        //Parametros
        int idEpisodio = Integer.parseInt(JOptionPane.showInputDialog("Insira o 'n�mero do epis�dio' <Caso seja filme, digite '0'>"));
        int idTemporada = Integer.parseInt(JOptionPane.showInputDialog("Insira o 'n�mero da temporada' <Caso seja filme, digite '0'>"));
        int idSerie = Integer.parseInt(JOptionPane.showInputDialog("Digite o Identificador da s�rie <Caso seja filme, digite '0'>"));
        int idClassificacao = Integer.parseInt(JOptionPane.showInputDialog("Insira o ID da Classifica��o Indicativa"));
        int idCategoria = Integer.parseInt(JOptionPane.showInputDialog("Insira o ID da Categoria"));
        int idTipoConteudo = Integer.parseInt(JOptionPane.showInputDialog("Insira o ID do tipo de Conteudo"));
        String nome = JOptionPane.showInputDialog("Digite o nome do Filme ou do Ep�s�dio: ");
        String nomeSerie = JOptionPane.showInputDialog("Digite o nome da serie, caso exista: ");
        String sinopse = JOptionPane.showInputDialog("Insira a sinopse do filme ou do epis�dio: ");
        String dataExpiracao = JOptionPane.showInputDialog("Insira a data de expira��o: ");
        int anoLancamento = Integer.parseInt(JOptionPane.showInputDialog("Insira o ano de lan�amento: "));
        String duracao = JOptionPane.showInputDialog("Insira o tempo de dura��o");

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        Date dataExpiracaoCv = null;

        try {
            dataExpiracaoCv = dateFormat.parse(dataExpiracao);
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }

        //Incializa a transacao
        em.getTransaction().begin();

        // passando as vari�veis como par�metro

        Portfolio portfolioAlterar = portfolioDao.buscarPorId(id);

        portfolioDao.alterarPortfolio(portfolioAlterar);

        portfolioAlterar.setIdEpisodio(idEpisodio);
        portfolioAlterar.setIdTemporada(idTemporada);
        portfolioAlterar.setIdSerie(idSerie);
        portfolioAlterar.setIdClassificacao(idClassificacao);
        portfolioAlterar.setIdCategoria(idCategoria);
        portfolioAlterar.setTipoConteudo(idTipoConteudo);
        portfolioAlterar.setNome(nome);
        portfolioAlterar.setNomeSerie(nomeSerie);
        portfolioAlterar.setSinopse(sinopse);
        portfolioAlterar.setAnoLancamento(anoLancamento);
        portfolioAlterar.setDuracao(duracao);

        //valida a transa��o
        em.getTransaction().commit();

        //fecha a conexao com o banco
        em.close();
    }

    //Usuario
    //Consultar
    private static String consultarUsuario() {
        //Fazendo conexao com o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        UsuarioDao usuarioDao = new UsuarioDao(em);

        List<Usuario> todosUsuarios = usuarioDao.consultarTodos();
        int tam = todosUsuarios.size();
        resultado = "Estes s�o os usu�rios dispon�veis: \n";
        //Concatenar todas as categorias no resultado

        for (int i = 0; i < tam; i++) {
            String formaPagamento = "";
            if (todosUsuarios.get(i).getFormaPagamento() == 1) {
                formaPagamento = " - Cart�o de Cr�dito ";
            }
            resultado += todosUsuarios.get(i).getIdUsuario() + " - " +
                    todosUsuarios.get(i).getNomeUsuario() + " - " +
                    todosUsuarios.get(i).getEmail() + " - " +
                    todosUsuarios.get(i).getFormaPagamento() + formaPagamento + " - " +
                    todosUsuarios.get(i).getPlano() + "\n";
        }
        return resultado;
    }

    private static String consultarUsuarioSimplificado() {
        //Fazendo conexao com o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        UsuarioDao usuarioDao = new UsuarioDao(em);

        List<Usuario> todosUsuarios = usuarioDao.consultarTodos();
        int tam = todosUsuarios.size();
        resultado = "Estes s�o os usu�rios dispon�veis: \n";
        //Concatenar todas as categorias no resultado

        for (int i = 0; i < tam; i++) {
            String formaPagamento = "";
            if (todosUsuarios.get(i).getFormaPagamento() == 1) {
                formaPagamento = " - Cart�o de Cr�dito ";
            }
            resultado += todosUsuarios.get(i).getIdUsuario() + " - " +
                    todosUsuarios.get(i).getNomeUsuario() + " - " +
                    todosUsuarios.get(i).getEmail() + " - " + "\n";
        }
        return resultado;
    }

    //Cadastrar
    private static void cadastrarUsuario(int formaPagamento, String email, String nomeUsuario, int plano) {
        Usuario usuario = new Usuario(formaPagamento, email, nomeUsuario, plano);

        //Conexao com o banco
        EntityManager em = JPAUtil.getEntityManager();
        UsuarioDao usuarioDao = new UsuarioDao(em);

        //Incializa a transacao
        em.getTransaction().begin();

        //m�todo para cadastrar no banco
        usuarioDao.cadastrar(usuario);

        //valida a transa��o
        em.getTransaction().commit();

        //fecha a conexao com o banco
        em.close();
    }

    //Editar
    private static void editarUsuario() {

        //Fazendo conexao com o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        UsuarioDao usuarioDao = new UsuarioDao(em);

        resultado = consultarUsuario();

        int id = Integer.parseInt(JOptionPane.showInputDialog(resultado + "\n" +
                "Qual 'Usuario' deseja alterar? <Selecione a ID> "));

        //Parametros
        String nomeUsuario = JOptionPane.showInputDialog("Digite o nome completo do usu�rio: ");
        String email = JOptionPane.showInputDialog("Digite o email do usuario: ");
        JOptionPane.showMessageDialog(null, "Formas de Pagamento, identifique o <ID> desejado: ");
        JOptionPane.showMessageDialog(null, consultarFormaPagamento());
        int formaPagamento = Integer.parseInt(JOptionPane.showInputDialog("Digite o <ID> desejado: "));
        JOptionPane.showMessageDialog(null, "Planos dispon�veis, identifique o <ID> desejado: ");
        JOptionPane.showMessageDialog(null, consultarPlano());
        int plano = Integer.parseInt(JOptionPane.showInputDialog("Digite o <ID> do plano desejado: "));

        //Incializa a transacao
        em.getTransaction().begin();

        // passando as vari�veis como par�metro

        Usuario usuarioAlterar = usuarioDao.buscarPorId(id);

        usuarioDao.alterarUsuario(usuarioAlterar);

        usuarioAlterar.setNomeUsuario(nomeUsuario);
        usuarioAlterar.setEmail(email);
        usuarioAlterar.setFormaPagamento(formaPagamento);
        usuarioAlterar.setPlano(plano);

        //valida a transa��o
        em.getTransaction().commit();

        //fecha a conexao com o banco
        em.close();
    }

    //Perfil
    //Consultar Perfis

    private static String consultarPerfil() {
        //Fazendo conexao com o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        PerfilDao perfilDao = new PerfilDao(em);

        List<Perfil> todosPerfils = perfilDao.consultarTodos();
        int tam = todosPerfils.size();
        resultado = "Estes s�o os perfils dispon�veis: \n";
        //Concatenar todas as categorias no resultado
        for (int i = 0; i < tam; i++) {
            resultado += todosPerfils.get(i).getIdPerfil() + " - " +
                    todosPerfils.get(i).getNickName() + "\n";
        }
        return resultado;
    }

    //Consultar perfil espec�fico para um ID

    private static String consultarPerfilporId(int idUsuario) {
        //Fazendo conexao com o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        PerfilDao perfilDao = new PerfilDao(em);

        List<Perfil> todosPerfilPorId = perfilDao.consultarPerfisPorId(idUsuario);
        int tam = todosPerfilPorId.size();
        resultado = "Estes s�o os perfils dispon�veis: \n";
        //Concatenar todas as categorias no resultado
        for (int i = 0; i < tam; i++) {
            resultado += todosPerfilPorId.get(i).getIdPerfil() + " - " +
                    todosPerfilPorId.get(i).getNickName() + "\n";
        }
        return resultado;
    }
    //Cadastrar Perfis

    private static void cadastrarPerfil(int idPerfil, int idUsuario, String nickName, boolean kids_profile) {

        Perfil perfil = new Perfil(idPerfil, idUsuario,  nickName, kids_profile);

        //Conexao com o banco
        EntityManager em = JPAUtil.getEntityManager();
        PerfilDao perfilDao = new PerfilDao(em);

        //Incializa a transacao
        em.getTransaction().begin();

        //m�todo para cadastrar no banco
        perfilDao.cadastrar(perfil);

        //valida a transa��o
        em.getTransaction().commit();

        //fecha a conexao com o banco
        em.close();
    }

    //Editar Perfis
    private static void editarPerfil() {

        //Fazendo conexao com o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        PerfilDao perfilDao = new PerfilDao(em);

        resultado = consultarUsuarioSimplificado();

        int idUsuario = Integer.parseInt(JOptionPane.showInputDialog(resultado + "\n" +
                "Para qual 'Usuario' deseja alterar o perfil? <Selecione a ID> "));

        //Parametros

        //JOptionPane.showMessageDialog(null, "'IDENTIFIQUE' o ID do Usu�rio para qual deseja alterar o PERFIL");
        //JOptionPane.showMessageDialog(null, consultarUsuarioSimplificado());

        //int idUsuario = Integer.parseInt(JOptionPane.showInputDialog("'DIGITE' o ID do Usu�rio para qual deseja alterar o Perfil"));
        //consultarPerfisPorId(int IdUsuario)

        JOptionPane.showMessageDialog(null, "Estes s�o os Perfils cadastrados para o Usu�rio informado: ");
        JOptionPane.showMessageDialog(null, consultarPerfilporId(idUsuario));

        int idPerfil = Integer.parseInt(JOptionPane.showInputDialog("'DIGITE' o ID do perfil a ser alterado"));
        //procurarUltimo-BuscarInfo  (select id from table order by id desc limit 1)

        String nickname = JOptionPane.showInputDialog("Digite o nome do perfil");
        boolean kids_profile = Boolean.parseBoolean(JOptionPane.showInputDialog("Informe se o perfil � infantil <1> Sim <0>N�o "));

        cadastrarPerfil(idUsuario, idPerfil, nickname, kids_profile);
        JOptionPane.showMessageDialog(null, "Perfil cadastrado com sucesso!");

        //Incializa a transacao
        em.getTransaction().begin();

        // passando as vari�veis como par�metro

       // System.out.println(perfilDao.buscarPorId(idUsuario));

      Perfil perfilAlterar = perfilDao.buscarPorId(idPerfil);

      perfilDao.alterarPerfil(perfilAlterar);

      perfilAlterar.setNickName(nickname);
      perfilAlterar.setKids_profile(kids_profile);

      //valida a transa��o
      em.getTransaction().commit();

      //fecha a conexao com o banco
      em.close();
    }

}

