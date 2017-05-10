/**
 * 
 * Copyright *
 *
 */
package com.pragmatic.bookself.employee.task;

import com.pragmatic.bookself.employee.EmployeeEntity;
import com.pragmatic.bookself.employee.EmployeeStorageManager;
import com.pragmatic.bookself.exception.PragmaticBookSelfException;
import com.pragmatic.bookself.result.PragmaticBookSelfResult;
import com.pragmatic.bookself.result.ResultCode;
import com.pragmatic.bookself.result.ResultCode.ResultCodes;
import com.pragmatic.bookself.session.PragmaticBookselfSession;
import com.pragmatic.bookself.storagecontext.StorageContext;
import com.pragmatic.bookself.task.core.PragmaticBookselfTask;

/**
 * @author amar
 *
 * @version 1.0
 */
public class InsertEmployeeDatatTask extends PragmaticBookselfTask<Integer> {

	private EmployeeEntity employee = null;

	/**
	 * constructor
	 */
	public InsertEmployeeDatatTask(EmployeeEntity employee) {
		this.employee = employee;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.pragamtic.bookself.task.core.PragmaticBookselfTask#validateParameter(
	 * com.pragmatic.bookself.session.PragmaticBookselfSession,
	 * com.pragmatic.bookself.storagecontext.StorageContext)
	 */
	@Override
	protected void validateParameter(PragmaticBookselfSession session, StorageContext context)
			throws PragmaticBookSelfException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pragamtic.bookself.task.core.PragmaticBookselfTask#execute(com.
	 * pragmatic.bookself.session.PragmaticBookselfSession,
	 * com.pragmatic.bookself.storagecontext.StorageContext)
	 */
	@Override
	protected PragmaticBookSelfResult<Integer> execute(PragmaticBookselfSession session, StorageContext context)
			throws PragmaticBookSelfException {
		// TODO Auto-generated method stub
		int resultId = 0;
		PragmaticBookSelfResult<Integer> result = new PragmaticBookSelfResult<Integer>();
		try {
			resultId = EmployeeStorageManager.getInstance().insertEmployeeData(employee, context);
		} catch (PragmaticBookSelfException pbe) {
			throw pbe;
		}
		result.setRestltedObject((Integer) resultId);
		result.setResultCode(new ResultCode(ResultCodes.SUCCESSFUL));
		return result;
	}

}
