package com.qintess.cervejaria.hibernate;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.qintess.cervejaria.classes.Cerveja;
import com.qintess.cervejaria.classes.Cidade;
import com.qintess.cervejaria.classes.Cliente;
import com.qintess.cervejaria.classes.Estado;
import com.qintess.cervejaria.classes.Estilo;
import com.qintess.cervejaria.classes.Grupo;
import com.qintess.cervejaria.classes.GrupoPermissao;
import com.qintess.cervejaria.classes.ItemVenda;
import com.qintess.cervejaria.classes.Permissao;
import com.qintess.cervejaria.classes.Usuario;
import com.qintess.cervejaria.classes.UsuarioGrupo;
import com.qintess.cervejaria.classes.Venda;

public class HibernateUtil {
	
	private static SessionFactory fabricaSessoes;
	
	public static SessionFactory getFabricaSessoes() {
		if (fabricaSessoes != null) {
			try {
				Configuration config = new Configuration();
				Properties prop = new Properties();
				
				prop.put(Environment.DRIVER, "org.postgresql.Driver");
				prop.put(Environment.URL, "jdbc:postgresql://localhost:5432/cervejaria");
				prop.put(Environment.USER, "postgres");
				prop.put(Environment.PASS, "1234");
				
				prop.put(Environment.SHOW_SQL, "true");
				prop.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL95Dialect");
				prop.put(Environment.HBM2DDL_AUTO, "update");
				
				config.setProperties(prop);
				
				config.addAnnotatedClass(Cerveja.class);
				config.addAnnotatedClass(Cidade.class);
				config.addAnnotatedClass(Cliente.class);
				config.addAnnotatedClass(Estado.class);
				config.addAnnotatedClass(Estilo.class);
				config.addAnnotatedClass(Grupo.class);
				config.addAnnotatedClass(GrupoPermissao.class);
				config.addAnnotatedClass(ItemVenda.class);
				config.addAnnotatedClass(Permissao.class);
				config.addAnnotatedClass(Usuario.class);
				config.addAnnotatedClass(UsuarioGrupo.class);
				config.addAnnotatedClass(Venda.class);
				
				
				ServiceRegistry servico = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
				
				fabricaSessoes = config.buildSessionFactory(servico);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return fabricaSessoes;
	}

	public static Object getPrimaryKey(Object entidade) {
		return fabricaSessoes.getPersistenceUnitUtil().getIdentifier(entidade);
	}
}
