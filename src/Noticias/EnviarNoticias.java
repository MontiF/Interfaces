package Noticias;

public class EnviarNoticias {
	public static void enviarTodasNoticias(Usuario usuario) {
		String correo = usuario.getCorreo();

		String noticia1Economia = BuscarNoticias.noticia1Economia();
		String noticia2Economia = BuscarNoticias.noticia2Economia();
		String noticia3Economia = BuscarNoticias.noticia3Economia();

		String noticia1Deportes = BuscarNoticias.noticia1Deportes();
		String noticia2Deportes = BuscarNoticias.noticia2Deportes();
		String noticia3Deportes = BuscarNoticias.noticia3Deportes();

		String noticia1Nacional = BuscarNoticias.noticia1Nacional();
		String noticia2Nacional = BuscarNoticias.noticia2Nacional();
		String noticia3Nacional = BuscarNoticias.noticia3Nacional();

		String noticia1Internacional = BuscarNoticias.noticia1Internacional();
		String noticia2Internacional = BuscarNoticias.noticia2Internacional();
		String noticia3Internacional = BuscarNoticias.noticia3Internacional();

		String noticia1Videojuegos = BuscarNoticias.noticia1Videojuegos();
		String noticia2Videojuegos = BuscarNoticias.noticia2Videojuegos();
		String noticia3Videojuegos = BuscarNoticias.noticia3Videojuegos();

		String noticia1Politica = BuscarNoticias.noticia1Politica();
		String noticia2Politica = BuscarNoticias.noticia2Politica();
		String noticia3Politica = BuscarNoticias.noticia3Politica();

		String correoCompleto = 
				"ECONOMÍA\n" + "   • " + noticia1Economia + "\n" + "   • " + noticia2Economia + "\n" + "   • " + noticia3Economia+ "\n\n" +

				"DEPORTES\n" + "   • " + noticia1Deportes + "\n" + "   • " + noticia2Deportes  + "\n" + "   • " + noticia3Deportes+ "\n\n" +

				"NACIONAL\n" + "   • " + noticia1Nacional + "\n" + "   • " + noticia2Nacional  + "\n" + "   • " + noticia3Nacional+ "\n\n" +

				"INTERNACIONAL\n" + "   • " + noticia1Internacional + "\n" + "   • " + noticia2Internacional  + "\n" + "   • " + noticia3Internacional+ "\n\n" +

				"VIDEOJUEGOS\n" + "   • " + noticia1Videojuegos + "\n" + "   • " + noticia2Videojuegos  + "\n" + "   • " + noticia3Videojuegos+ "\n\n" +

				"POLÍTICA\n" + "   • " + noticia1Politica + "\n" + "   • " + noticia2Politica  + "\n" + "   • " + noticia3Politica+ "\n";
		EmailEnviar.EmailNoticias(correo, correoCompleto);
	}
	public static String guardarNoticiasUsuario(Usuario usuario) {
		String nombre = usuario.getNombreUsuario();
		String economia = "";
		String deportes = "";
		String nacional = "";
		String internacional = "";
		String videojuegos = "";
		String politica = "";
		
		if(BuscarNoticias.comprobarConfiguracion("economia", nombre)) {
			String noticia1Economia = BuscarNoticias.noticia1Economia();
			String noticia2Economia = BuscarNoticias.noticia2Economia();
			String noticia3Economia = BuscarNoticias.noticia3Economia();
			economia = "ECONOMÍA\n" + "   • " + noticia1Economia + "\n" + "   • " + noticia2Economia + "\n" + "   • " + noticia3Economia+ "\n\n";
		}
	    if(BuscarNoticias.comprobarConfiguracion("deportes", nombre)) {
	    	String noticia1Deportes = BuscarNoticias.noticia1Deportes();
			String noticia2Deportes = BuscarNoticias.noticia2Deportes();
			String noticia3Deportes = BuscarNoticias.noticia3Deportes();
			deportes = "DEPORTES\n" + "   • " + noticia1Deportes + "\n" + "   • " + noticia2Deportes + "\n" + "   • " + noticia3Deportes+ "\n\n";
	    }
	    if(BuscarNoticias.comprobarConfiguracion("nacional", nombre)) {
	    	String noticia1Nacional = BuscarNoticias.noticia1Nacional();
			String noticia2Nacional = BuscarNoticias.noticia2Nacional();
			String noticia3Nacional = BuscarNoticias.noticia3Nacional();
			nacional = "NACIONAL\n" + "   • " + noticia1Nacional + "\n" + "   • " + noticia2Nacional + "\n" + "   • " + noticia3Nacional+ "\n\n";
	    }
	    if(BuscarNoticias.comprobarConfiguracion("internacional", nombre)) {
	    	String noticia1Internacional = BuscarNoticias.noticia1Internacional();
			String noticia2Internacional = BuscarNoticias.noticia2Internacional();
			String noticia3Internacional = BuscarNoticias.noticia3Internacional();
			internacional = "INTERNACIONAL\n" + "   • " + noticia1Internacional + "\n" + "   • " + noticia2Internacional + "\n" + "   • " + noticia3Internacional+ "\n\n";
	    }
	    if(BuscarNoticias.comprobarConfiguracion("videojuegos", nombre)) {
	    	String noticia1Videojuegos = BuscarNoticias.noticia1Videojuegos();
			String noticia2Videojuegos = BuscarNoticias.noticia2Videojuegos();
			String noticia3Videojuegos = BuscarNoticias.noticia3Videojuegos();
			videojuegos = "VIDEOJUEGOS\n" + "   • " + noticia1Videojuegos + "\n" + "   • " + noticia2Videojuegos + "\n" + "   • " + noticia3Videojuegos+ "\n\n";
	    }
	    if(BuscarNoticias.comprobarConfiguracion("politica", nombre)) {
	    	String noticia1Politica = BuscarNoticias.noticia1Politica();
			String noticia2Politica = BuscarNoticias.noticia2Politica();
			String noticia3Politica = BuscarNoticias.noticia3Politica();
			politica = "POLÍTICA\n" + "   • " + noticia1Politica + "\n" + "   • " + noticia2Politica + "\n" + "   • " + noticia3Politica+ "\n";
	    }
	    String StringCompleto = economia + deportes + nacional + internacional + videojuegos + politica;
	    return StringCompleto;
	   
	}
	public static void enviarNoticiasUsuario(Usuario usuario) {
		String correo = usuario.getCorreo();
	    String correoCompleto = guardarNoticiasUsuario(usuario);
	    EmailEnviar.EmailNoticias(correo, correoCompleto);
	}
}
