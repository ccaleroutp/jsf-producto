package pe.edu.utp.jsf.producto.beans;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import java.util.List;
import pe.edu.utp.jsf.producto.dao.ProductoDAO;
import pe.edu.utp.jsf.producto.modelo.Producto;

/**
 *
 * @author Christiam Calero
 */
@Named(value = "productoBean")
@ViewScoped
public class ProductoBean implements Serializable {

    private Producto newProducto;
    private List<Producto> listProductos;

    /**
     * Creates a new instance of ProductoBean
     */
    public ProductoBean() {
    }

    public Producto getNewProducto() {
        return newProducto;
    }

    public void setNewProducto(Producto newProducto) {
        this.newProducto = newProducto;
    }

    public List<Producto> getListProductos() {
        return listProductos;
    }

    public void setListProductos(List<Producto> listProductos) {
        this.listProductos = listProductos;
    }

    @Inject
    private ProductoDAO dao;

    @PostConstruct
    public void init() {
        newProducto = new Producto();
        listProductos = dao.listar();
    }

    public void eliminar(int idProducto) {
        dao.eliminar(idProducto);
        listProductos = dao.listar();
    }

    public void editar(Producto producto) {
        newProducto = new Producto(
                producto.getCodigo(),
                producto.getNombre(),
                producto.getPrecio(),
                producto.getStock());
    }

    public void guardar() {
        if (newProducto.getCodigo() == null) {
            dao.agregar(newProducto);
        } else {
            dao.actualizar(newProducto);
        }
        newProducto = new Producto();
        listProductos = dao.listar();
    }
}
