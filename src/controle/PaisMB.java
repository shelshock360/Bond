package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import banco.DAOGenerico;
import modelo.Pais;


@ManagedBean
@ViewScoped 
public class PaisMB {

	private Pais pais = new Pais();
	private List<Pais> paises = new ArrayList<>();
	private DAOGenerico<Pais> dao = new DAOGenerico<>(Pais.class);

	public PaisMB() {

		paises = dao.buscarTodos();
	}
	
	public void inserir() {
		
		if(pais.getId()==null) {
			
			dao.salvar(pais);
		}else {
			
			dao.alterar(pais);
		}
		
		pais=new Pais();
		paises=dao.buscarTodos();
	
	}
	

	public void excluir (Long id){
		
		dao.excluir(id);
		paises=dao.buscarTodos();
		
		
	}
	
	
	
	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public List<Pais> getPaises() {
		return paises;
	}

	public void setPaises(List<Pais> paises) {
		this.paises = paises;
	}

	
	


}
