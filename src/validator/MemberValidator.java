package validator;

import model.Member;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import service.MemberService;

public class MemberValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return Member.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		// TODO Auto-generated method stub
		Member m = (Member) arg0;
		if (m.getId() == null || m.getId().trim().isEmpty()) {
			errors.rejectValue("id", "required");
		}
		if (m.getPwd() == null || m.getPwd().trim().isEmpty()) {
			errors.rejectValue("pwd", "required");
		}
		if (m.getName() == null || m.getName().trim().isEmpty()) {
			errors.rejectValue("name", "required");
		}
		if (m.getSg() == 0) {
			errors.rejectValue("sg", "required");
		}
		if (m.getTel() == null || m.getTel().trim().isEmpty()) {
			errors.rejectValue("tel", "required");
		}
	}
}
