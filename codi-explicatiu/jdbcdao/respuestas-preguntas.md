**SESIONES Y FILTROS**

**a) Per què el filtre fa servir getSession(false) i no getSession()?**

Se usa el getSessions(false) y no el otro porque con este primero se comprueba si existe un usuario, si no es el caso, se le puede redirigir a login apra que inicie sesión. Si se usase el otro método se crearía una sesión de forma automática

**b) Per què hem mogut el formulari a /gestio/ en lloc de posar el filtre a /tallers?**

Se ha movido a /gestio/ y aque la pagina de talleres, aunque no tengas una sesión ha de seguir pudiéndose ver

**c) Deixes el formulari de crear obert en una pestanya, surts des d'una altra pestanya i després prems 
«Crear» a la primera. Què passa? Per què?**

Lo que pasaria es que el taller no se crearía ya que la sesión ya se abría cerrado
