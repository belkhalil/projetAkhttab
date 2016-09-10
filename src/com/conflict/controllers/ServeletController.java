package com.conflict.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conflict.dao.AssertionDao;
import com.conflict.dao.BehaviorDao;
import com.conflict.dao.FactDao;
import com.conflict.dao.HealthProviderDao;
import com.conflict.dao.PatientDao;
import com.conflict.dao.PrivacyPolicyDao;
import com.conflict.dao.QueryDao;
import com.conflict.dao.UserPrefDao;
import com.conflict.dao.lawDao;
import com.conflict.entities.Assertion;
import com.conflict.entities.Beh;
import com.conflict.entities.Fact;
import com.conflict.entities.HealthProvider;
import com.conflict.entities.Patient;
import com.conflict.entities.Privacypolicy;
import com.conflict.entities.Query;
import com.conflict.entities.UserPref;
import com.conflict.entities.law;

/**
 * Servlet implementation class ServeletController
 */
@WebServlet("/ServeletController")
public class ServeletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HealthProviderDao healthProviderDao;
	lawDao lawDao;
	PrivacyPolicyDao privacyPolicyDao;
	PatientDao patientDao;
	UserPrefDao userPrefDao;
	QueryDao queryDao;
	FactDao factDao;
	BehaviorDao behaviorDao;
	AssertionDao assertionDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServeletController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init();
		healthProviderDao = new HealthProviderDao();
		lawDao = new lawDao();
		privacyPolicyDao = new PrivacyPolicyDao();
		patientDao = new PatientDao();
		userPrefDao = new UserPrefDao();
		queryDao = new QueryDao();
		factDao = new FactDao();
		behaviorDao = new BehaviorDao();
		assertionDao = new AssertionDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HealthProvider healthProvider = new HealthProvider();
		law law = new law();
		Privacypolicy privacypolicy = new Privacypolicy();
		Privacypolicy privacypolicy2 = new Privacypolicy();

		// String actionS = request.getParameter("btns");
		String action = request.getParameter("btn");
		// ask for compliance parameters
		String covred = request.getParameter("covred");
		String nomLaw = request.getParameter("nomLaw");
		String location = request.getParameter("location");
		String name = request.getParameter("nom");
		String privacyP = request.getParameter("privacyP");
		String privacyPl = request.getParameter("privacyPl");
		// patient parameters
		String nomPatient = request.getParameter("nomPatient");
		String pays = request.getParameter("pays");
		String locationPatient = request.getParameter("locationP");
		String privacyGroupe = request.getParameter("privacyGroup");
		String userPreference = request.getParameter("userPreference");

		String subject;
		String espace;
		String subject1;
		String relation;
		int nbfact = 0;
		Beh behavior = new Beh();
		// la liste globale des quiries
		List<Query> queries = null;
		// la liste globale des ssertions
		List<Assertion> assertions = null;

		// ask for satisfaction parameters

		System.out.println("la location li ktabti hya " + location);
		System.out.println("le nom li ktabti howa " + name);
		System.out.println("covred li ktabti hya " + covred);
		System.out.println("le nomLaw li ktabti howa " + nomLaw);
		/**
		 * **********Ask for Compliance
		 * *******************************************************
		 */
		if (action.equals("Compare")) {
			// privacy policy of heathcar provider
			Privacypolicy newp = new Privacypolicy();
			privacypolicy.setDescription(privacyP);
			newp = privacyPolicyDao.Add(privacypolicy);
			// privacy policy of law
			Privacypolicy newpL = new Privacypolicy();
			privacypolicy2.setDescription(privacyPl);
			newpL = privacyPolicyDao.Add(privacypolicy2);
			// adding a helthcar provider
			healthProvider.setLocation(location);
			healthProvider.setNom(name);
			HealthProvider newHeathpro = new HealthProvider();
			newHeathpro = healthProviderDao.Add(healthProvider);
			// System.out.println("ghanzido hada " + newp.getId());
			// System.out.println("l hada " + newHeathpro.getId());
			// adding privacy to heathcar provider
			healthProviderDao.AddprivacyToHealthPro(newHeathpro, newp);
			// adding a new law
			law.setCovered(covred);
			law.setNom(nomLaw);
			law newLaw = new law();
			newLaw = lawDao.Add(law);
			// adding privacy to law
			lawDao.AddPrivacyToLaw(newpL, newLaw);
			
			
			List <law> laws= (List<law>) lawDao.getAll();
			HttpSession session = request.getSession(true);
			session.setAttribute("laws", laws);
			for (int i = 0; i < laws.size(); i++) {
				System.out.println(laws.get(i).getNom());
			}
			
			
			response.sendRedirect("gestionCompliance.jsp");

			/************************************************************************
			 * comparaison les deux objet homa newHeathpro et newLaw
			 **********************************************************************/
			// hadi la partie dyal newHealthpo

			if (newHeathpro.getPrivacypolicy().getDescription().contains("?")) {
				Query q = new Query();
				q.setContenu(newHeathpro.getPrivacypolicy().getDescription().substring(0,
						newHeathpro.getPrivacypolicy().getDescription().indexOf('?') + 1));
				Query qq = new Query();
				qq = queryDao.Add(q);
				privacyPolicyDao.AddQueryToPrivacy(qq, newHeathpro.getPrivacypolicy());

				// l'ajout de notre quirie a la liste globale des quiries
				queries.add(q);

				if (newHeathpro.getPrivacypolicy().getDescription().contains("¬")) {
					q.setType("non");
					queryDao.Update(q);
				} else if (newHeathpro.getPrivacypolicy().getDescription().contains("∧")) {
					q.setType("and");
					queryDao.Update(q);
				} else if (newHeathpro.getPrivacypolicy().getDescription().contains("∨")) {
					q.setType("or");
					queryDao.Update(q);
				} else if (newHeathpro.getPrivacypolicy().getDescription().contains("∃")) {
					q.setType("existe");
					queryDao.Update(q);
				} else {
					q.setType("simple");
					queryDao.Update(q);
				}

				subject = q.getContenu().substring(0, q.getContenu().indexOf("says"));
				Fact fact = new Fact();
				fact.setContenu(
						q.getContenu().substring(q.getContenu().indexOf("says") + 5, q.getContenu().indexOf("?")));
				Fact ff = new Fact();
				ff = factDao.Add(fact);
				queryDao.AddFactToQuery(ff, qq);

				if (factDao.Contain("can say", fact.getContenu())) {
					espace = fact.getContenu().substring(fact.getContenu().indexOf("can say") + 8);
					String[] tab = espace.split(" ");
					subject1 = tab[0];
					relation = "can say";
					Fact fact2 = new Fact();
					String fact22 = fact.getContenu().substring(fact.getContenu().indexOf("can say") + 8,
							fact.getContenu().length());
					fact2.setContenu(fact22);

				} else if (factDao.Contain("may", fact.getContenu())) {
					relation = "may";

					behavior.setCont(fact.getContenu().substring(fact.getContenu().indexOf("may") + 4,
							fact.getContenu().length()));
					behaviorDao.Add(behavior);
					factDao.addBehaviorToFact(behavior, fact);
				} else if (factDao.Contain("will", fact.getContenu())) {
					relation = "will";
					//

					behavior.setCont(fact.getContenu().substring(fact.getContenu().indexOf("will") + 5,
							fact.getContenu().length()));
					factDao.addBehaviorToFact(behavior, fact);
					factDao.addBehaviorToFact(behavior, fact);
				} else {
					relation = null;
					behavior.setCont(fact.getContenu());
					factDao.addBehaviorToFact(behavior, fact);
				}
			} else {
				Assertion assertion = new Assertion();
				assertion.setContenu(newHeathpro.getPrivacypolicy().getDescription().substring(0,
						newHeathpro.getPrivacypolicy().getDescription().indexOf('.') + 1));
				Assertion ass = assertionDao.Add(assertion);

				if (factDao.Contain("if", assertion.getContenu())) {
					// System.out.println(nbfact); ??????????????/

					for (int i = 0; i < assertion.getContenu().length(); i++) {
						if (assertion.getContenu().charAt(i) == ',')
							nbfact++;

						String hh = assertion.getContenu().substring(assertion.getContenu().indexOf("if") + 3,
								assertion.getContenu().indexOf(","));
						System.out.println(hh);
					}
				} else if (factDao.Contain("where", assertion.getContenu())) {

					String condition = assertion.getContenu().substring(assertion.getContenu().indexOf("where") + 5,
							assertion.getContenu().length() - 1);
					behavior.setCond(condition);
				}

			}
			// daba la partie dyal newLaw

			/**********************************************************************/
			/**
			 * **********Ask for
			 * satisfaction***************************************************
			 */
		} else if (action.equals("Validate")) {

			Privacypolicy newp = new Privacypolicy();
			privacypolicy.setDescription(privacyP);
			newp = privacyPolicyDao.Add(privacypolicy);

			healthProvider.setLocation(location);
			healthProvider.setNom(name);
			HealthProvider newHeathpro = new HealthProvider();
			newHeathpro = healthProviderDao.Add(healthProvider);

			// associer une privacy policy a un health proviser
			healthProviderDao.AddprivacyToHealthPro(newHeathpro, newp);

			Patient p = new Patient();
			p.setNom(nomPatient);
			p.setLocation(locationPatient);
			p.setPays(pays);
			p.setPrivacyGroup(privacyGroupe);

			Patient newPatient = new Patient();
			newPatient = patientDao.Add(p);
			UserPref userPref = new UserPref();
			userPref.setContenu(userPreference);
			UserPref newUser = new UserPref();
			newUser = userPrefDao.Add(userPref);

			patientDao.addUserPrefToPatient(newUser, newPatient);

			/************************************************************************
			 * comparaison les deux objet homa newHeathpro et newPatient
			 **********************************************************************/
			// hadi dyal newHealthpro

			if (newHeathpro.getPrivacypolicy().getDescription().contains("?")) {
				Query q = new Query();
				q.setContenu(newHeathpro.getPrivacypolicy().getDescription().substring(0,
						newHeathpro.getPrivacypolicy().getDescription().indexOf('?') + 1));
				Query qq = new Query();
				qq = queryDao.Add(q);
				privacyPolicyDao.AddQueryToPrivacy(qq, newHeathpro.getPrivacypolicy());
				queries.add(q);
				if (newHeathpro.getPrivacypolicy().getDescription().contains("¬")) {
					q.setType("non");
					queryDao.Update(q);
				} else if (newHeathpro.getPrivacypolicy().getDescription().contains("∧")) {
					q.setType("and");
					queryDao.Update(q);
				} else if (newHeathpro.getPrivacypolicy().getDescription().contains("∨")) {
					q.setType("or");
					queryDao.Update(q);
				} else if (newHeathpro.getPrivacypolicy().getDescription().contains("∃")) {
					q.setType("existe");
					queryDao.Update(q);
				} else {
					q.setType("simple");
					queryDao.Update(q);
				}

				subject = q.getContenu().substring(0, q.getContenu().indexOf("says"));
				Fact fact = new Fact();
				fact.setContenu(
						q.getContenu().substring(q.getContenu().indexOf("says") + 5, q.getContenu().indexOf("?")));
				Fact ff = new Fact();
				ff = factDao.Add(fact);
				queryDao.AddFactToQuery(ff, qq);

				if (factDao.Contain("can say", fact.getContenu())) {
					espace = fact.getContenu().substring(fact.getContenu().indexOf("can say") + 8);
					String[] tab = espace.split(" ");
					subject1 = tab[0];
					relation = "can say";
					Fact fact2 = new Fact();
					String fact22 = fact.getContenu().substring(fact.getContenu().indexOf("can say") + 8,
							fact.getContenu().length());
					fact2.setContenu(fact22);

				} else if (factDao.Contain("may", fact.getContenu())) {
					relation = "may";

					behavior.setCont(fact.getContenu().substring(fact.getContenu().indexOf("may") + 4,
							fact.getContenu().length()));
					behaviorDao.Add(behavior);
					factDao.addBehaviorToFact(behavior, fact);
				} else if (factDao.Contain("will", fact.getContenu())) {
					relation = "will";
					//

					behavior.setCont(fact.getContenu().substring(fact.getContenu().indexOf("will") + 5,
							fact.getContenu().length()));
					factDao.addBehaviorToFact(behavior, fact);
					factDao.addBehaviorToFact(behavior, fact);
				} else {
					relation = null;
					behavior.setCont(fact.getContenu());
					factDao.addBehaviorToFact(behavior, fact);
				}
			} else {
				Assertion assertion = new Assertion();
				assertion.setContenu(newHeathpro.getPrivacypolicy().getDescription().substring(0,
						newHeathpro.getPrivacypolicy().getDescription().indexOf('.') + 1));
				Assertion ass = assertionDao.Add(assertion);

				if (factDao.Contain("if", assertion.getContenu())) {
					// System.out.println(nbfact); ??????????????/

					for (int i = 0; i < assertion.getContenu().length(); i++) {
						if (assertion.getContenu().charAt(i) == ',')
							nbfact++;

						String hh = assertion.getContenu().substring(assertion.getContenu().indexOf("if") + 3,
								assertion.getContenu().indexOf(","));
						System.out.println(hh);
					}
				} else if (factDao.Contain("where", assertion.getContenu())) {

					String condition = assertion.getContenu().substring(assertion.getContenu().indexOf("where") + 5,
							assertion.getContenu().length() - 1);
					behavior.setCond(condition);
				}

			}

			// ba9a la partie dyal newPatient

			/**********************************************************************/

			response.sendRedirect("gestionSatisfaction.jsp");
		}

		
		
	}

}
