package Noticias;

public class EnviarNoticias {
	public static void enviarTodasNoticias(Usuario usuario) {
		String correo = usuario.getCorreo();

		String noticia1Economia = BuscarNoticias.noticia1Economia();
		String noticia2Economia = BuscarNoticias.noticia2Economia();

		String noticia1Deportes = BuscarNoticias.noticia1Deportes();
		String noticia2Deportes = BuscarNoticias.noticia2Deportes();

		String noticia1Nacional = BuscarNoticias.noticia1Nacional();
		String noticia2Nacional = BuscarNoticias.noticia2Nacional();

		String noticia1Internacional = BuscarNoticias.noticia1Internacional();
		String noticia2Internacional = BuscarNoticias.noticia2Internacional();

		String noticia1Videojuegos = BuscarNoticias.noticia1Videojuegos();
		String noticia2Videojuegos = BuscarNoticias.noticia2Videojuegos();

		String noticia1Politica = BuscarNoticias.noticia1Politica();
		String noticia2Politica = BuscarNoticias.noticia2Politica();

		String correoCompleto = 
				"ECONOMÍA\n" + "   • " + noticia1Economia + "\n" + "   • " + noticia2Economia + "\n\n" +

				"DEPORTES\n" + "   • " + noticia1Deportes + "\n" + "   • " + noticia2Deportes + "\n\n" +

				"NACIONAL\n" + "   • " + noticia1Nacional + "\n" + "   • " + noticia2Nacional + "\n\n" +

				"INTERNACIONAL\n" + "   • " + noticia1Internacional + "\n" + "   • " + noticia2Internacional + "\n\n" +

				"VIDEOJUEGOS\n" + "   • " + noticia1Videojuegos + "\n" + "   • " + noticia2Videojuegos + "\n\n" +

				"POLÍTICA\n" + "   • " + noticia1Politica + "\n" + "   • " + noticia2Politica + "\n";
		EmailEnviar.EmailNoticias(correo, correoCompleto);
	}

	public static void enviarNoticiasUsuario(Usuario usuario) {
		String nombre = usuario.getNombreUsuario();
		String correo = usuario.getCorreo();
		String economia = "";
		String deportes = "";
		String nacional = "";
		String internacional = "";
		String videojuegos = "";
		String politica = "";
		
		if(BuscarNoticias.comprobarConfiguracion("economia", nombre)) {
			String noticia1Economia = BuscarNoticias.noticia1Economia();
			String noticia2Economia = BuscarNoticias.noticia2Economia();
			economia = "ECONOMÍA\n" + "   • " + noticia1Economia + "\n" + "   • " + noticia2Economia + "\n\n";
		}
	    if(BuscarNoticias.comprobarConfiguracion("deportes", nombre)) {
	    	String noticia1Deportes = BuscarNoticias.noticia1Deportes();
			String noticia2Deportes = BuscarNoticias.noticia2Deportes();
			deportes = "DEPORTES\n" + "   • " + noticia1Deportes + "\n" + "   • " + noticia2Deportes + "\n\n";
	    }
	    if(BuscarNoticias.comprobarConfiguracion("nacional", nombre)) {
	    	String noticia1Nacional = BuscarNoticias.noticia1Nacional();
			String noticia2Nacional = BuscarNoticias.noticia2Nacional();
			nacional = "NACIONAL\n" + "   • " + noticia1Nacional + "\n" + "   • " + noticia2Nacional + "\n\n";
	    }
	    if(BuscarNoticias.comprobarConfiguracion("internacional", nombre)) {
	    	String noticia1Internacional = BuscarNoticias.noticia1Internacional();
			String noticia2Internacional = BuscarNoticias.noticia2Internacional();
			internacional = "INTERNACIONAL\n" + "   • " + noticia1Internacional + "\n" + "   • " + noticia2Internacional + "\n\n";
	    }
	    if(BuscarNoticias.comprobarConfiguracion("videojuegos", nombre)) {
	    	String noticia1Videojuegos = BuscarNoticias.noticia1Videojuegos();
			String noticia2Videojuegos = BuscarNoticias.noticia2Videojuegos();
			videojuegos = "VIDEOJUEGOS\n" + "   • " + noticia1Videojuegos + "\n" + "   • " + noticia2Videojuegos + "\n\n";
	    }
	    if(BuscarNoticias.comprobarConfiguracion("politica", nombre)) {
	    	String noticia1Politica = BuscarNoticias.noticia1Politica();
			String noticia2Politica = BuscarNoticias.noticia2Politica();
			politica = "POLÍTICA\n" + "   • " + noticia1Politica + "\n" + "   • " + noticia2Politica + "\n";
	    }
	    String correoCompleto = economia + deportes + nacional + internacional + videojuegos + politica;
	    EmailEnviar.EmailNoticias(correo, correoCompleto);
	}
}
